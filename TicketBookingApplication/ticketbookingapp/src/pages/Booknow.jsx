import axios from "axios";
import { useEffect, useState } from "react";
import Swal from "sweetalert2";
import { apiUrls, baseUrl } from "../lib/constants";
import { format } from "date-fns";
import { useParams, useNavigate } from "react-router-dom";
import {findslot} from "../lib/util";
import SeatSelect from "./SeatSelect";

export default function Booknow() {
  const { id } = useParams();
  const navigate = useNavigate();
  const userid = sessionStorage.getItem("id");
  const [cost, setCost] = useState();
  const [occupied, setOccupied] = useState([]);
  const [showDate, setShowDate] = useState(format(new Date(), "yyyy-MM-dd"));
  const [seatNos, setSeatNos] = useState([]);
  const [movieShow, setmovieShow] = useState();

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!cost || !seatNos || seatNos.length === 0) {
      Swal.fire({
        title: "Error",
        icon: "error",
        text: "Please fill all details",
      });
      return;
    }
    axios
      .post(baseUrl + apiUrls.BOOKINGS_URL, {
        movieShowId: movieShow.movieShowId,
        userId: parseInt(userid),
        cost: cost,
        showDate: showDate,
        noOfSeats: seatNos.length,
        seatNums: seatNos,
      })
      .then((resp) => {
        Swal.fire({ title: "Success", text: resp.data });
        navigate("/mybookings");
      })
      .catch((err) => {

        console.log(showDate);
        Swal.fire({ title: "Error", text: err.response.data });
      });
  };

  const loadShowBookings = () => {
    axios
      .get(
        baseUrl +
          apiUrls.CHECK_SHOWS_BOOKING_URL +
          "?movieShowId=" +
          id +
          "&date=" +
          showDate
      )
      .then((resp) => {
        if (resp.data.length > 0) {
          const seatsOccupied = resp.data
            .filter((x) => x.state !== "Cancelled")
            .map((row) => row?.seatNos?.split(",").map((x) => +x))
            .flat();
          setOccupied(seatsOccupied);
        } else {
          setOccupied([]);
        }
      })
      .catch((err) => console.log(err.response.data));
  };

  useEffect(() => {
    loadShowBookings();
  }, [showDate]);

  useEffect(() => {
    const totalCost = seatNos.length * movieShow?.price;
    setCost(totalCost || 0);
  }, [seatNos, movieShow]);

  useEffect(() => {
    axios
      .get(baseUrl + apiUrls.SHOWS_URL + '/'+id)
      .then((resp) => setmovieShow(resp.data))
      .catch((err) => console.log(err.response.data));

    loadShowBookings();
  }, []);

  return (
    <div className="container mt-5">
      <h4>Booking Show</h4>
      {console.log("hello" + id)}
      <div className="row">
        <div className="col-sm-3">
          <div className="card">
            <img
              src={"http://localhost:8080/" + movieShow?.movie.poster}
              className="card-img-top"
              alt={movieShow?.movie.movieName}
            />
            <div className="card-body text-center">
              <h6>
                {movieShow?.movie.movieName} ({movieShow?.movie.year})
              </h6>
              <h6>{movieShow?.movie.description}</h6>
              <h6>Actor: {movieShow?.movie.actor}</h6>
              <h6>Actress: {movieShow?.movie.actress}</h6>
              <h6>Director: {movieShow?.movie.director}</h6>
              <hr />
              <h6>Theatre: {movieShow?.theatre.theatreDesc}</h6>
              <h6>Time Slot: {findslot(movieShow?.slot)}</h6>
            </div>
          </div>
        </div>
        <div className="col-sm-4">
          <form onSubmit={handleSubmit}>
            <div className="mb-2">
              <label>Select Show Date</label>
              <input
                type="date"
                min={format(new Date(), "yyyy-MM-dd")}
                value={showDate}
                onChange={(e) => setShowDate(e.target.value)}
                className="form-control"
              />
            </div>
            <div className="mb-2">
              <label>Ticket Price</label>
              <input
                type="text"
                value={movieShow?.price}
                readOnly
                className="form-control"
              />
            </div>
            <div className="mb-2">
              <label>Seat Numbers</label>
              <input
                type="text"
                readOnly
                value={seatNos}
                className="form-control"
              />
            </div>
            <div className="mb-2">
              <label>No Of Seats</label>
              <input
                type="number"
                min={1}
                readOnly
                value={seatNos.length}
                className="form-control"
              />
            </div>
            <div className="mb-2">
              <label>Total Cost</label>
              <input
                type="text"
                disabled
                value={cost}
                className="form-control"
              />
            </div>
            <button type="submit" className="btn btn-primary float-end">
              Book Now
            </button>
          </form>
        </div>
        <div className="col-sm-4">
          <SeatSelect occupied={occupied} setSeatNos={setSeatNos} />
        </div>
      </div>
    </div>
  );
}
