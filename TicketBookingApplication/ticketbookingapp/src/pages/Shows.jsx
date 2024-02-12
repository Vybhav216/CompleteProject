import axios from "axios";
import { format } from "date-fns";
import { useEffect, useState } from "react";
import swal from "sweetalert2";
import { apiUrls, baseUrl } from "../lib/constants";

export default function Shows() {
  const [movieShowsData, setMovieShowsData] = useState([]);
  const [movieShowStartDate, setMovieShowStartDate] = useState("");
  const [movieShowEndDate, setMovieShowEndDate] = useState("");
  const [slot, setslot] = useState("");
  const [price, setprice] = useState("");
  const [theatreId, setTheatreId] = useState("");
  const [selectedMovieId, setSelectedMovieId] = useState("");
  const [moviesList, setMoviesList] = useState([]);
  const [theatresList, setTheatresList] = useState([]);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (movieShowStartDate === "") {
      swal.fire({
        title: "Error",
        icon: "error",
        text: "Please fill all details",
      });
      return;
    }
    axios
      .post(baseUrl + apiUrls.SHOWS_URL, {
        movieShowStartDate:movieShowStartDate,
        theatreId:theatreId,
        movieId: selectedMovieId,
        movieShowEndDate:movieShowEndDate,
        slot,
        price
      })
      .then((resp) => {
        console.log(resp);
        swal.fire({
          title: "Success",
          text: resp.data,
        });
        setMovieShowStartDate("");
        setMovieShowEndDate("");
        setslot("");
        setprice("");
        setTheatreId("");
        setSelectedMovieId("");
        loadData();
      })
      .catch((err) => {
        swal.fire({
          title: "error",
          icon: "error",
          text: "Cannot save Show",
        });
      });
  };

  const handleDelete = (id) => {
    axios
      .delete(baseUrl + apiUrls.SHOWS_URL +'/'+ id)
      .then((resp) => {
        swal.fire({
          icon: "error",
          title: "Deleted",
          text: resp.data,
        });
        loadData();
      })
      .catch((err) => {
        swal.fire({
          title: "Error",
          icon: "error",
          text: "Cannot delete Hall",
        });
      });
  };

  const loadData = () => {
    axios.get(baseUrl + apiUrls.SHOWS_URL).then((resp) => {
      setMovieShowsData(resp.data);
    });
  };
  console.log(movieShowsData)
  useEffect(() => {
    axios.get(baseUrl + apiUrls.MOVIES_URL).then((resp) => {
      setMoviesList(resp.data);
    });
    axios.get(baseUrl + apiUrls.THEATRE_URL).then((resp) => {
      setTheatresList(resp.data);
    });
    loadData();
  }, []);

  return (
    <>
      <div className="container mt-5">
        <div className="row">
          <div className="col-sm-8">
            <h5 className="p-2">Shows List</h5>
            <table className="table table-bordered">
              <thead>
                <th>Id</th>
                <th>Movie Name</th>
                <th>Theatre Details</th>
                <th>Show Details</th>
                <th>Ticket</th>
                <th>Date</th>
                <th>Action</th>
              </thead>
              <tbody>
                
                {movieShowsData.map((x) => (
                  <tr key={x.movieShowId}>
                    <td>{x.movieShowId}</td>
                    <td>{x.movie.movieName}</td>
                    <td>{x.theatre.theatreDesc}</td>
                    <td>{x.slot}</td>
                    <td>{x.price}</td>
                    <td>
                      {x.movieShowStartDate} - {x.movieShowEndDate}
                    </td>
                    <td>
                      <button
                        onClick={(e) => handleDelete(x.movieShowId)}
                        className="btn btn-danger btn-sm"
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
          <div className="col-sm-4">
            <h5>Add Show</h5>
            <form>
              <div className="mb-2">
                <label>Movie</label>
                <select
                  className="form-control form-control-sm"
                  value={selectedMovieId}
                  onChange={(e) => setSelectedMovieId(e.target.value)}
                >
                  <option value="">Select Movie</option>
                  {moviesList.map((x) => (
                    <option key={x.movieId} value={x.movieId}>
                      {x.movieName}
                    </option>
                  ))}
                </select>
              </div>
              <div className="mb-2">
                <label>Theatre</label>
                <select
                  className="form-control form-control-sm"
                  value={theatreId}
                  onChange={(e) => setTheatreId(e.target.value)}
                >
                  <option value="">Select Hall</option>
                  {theatresList.map((x) => (
                    <option key={x.theatreId} value={x.theatreId}>
                      {x.theatreDesc}
                    </option>
                  ))}
                </select>
              </div>
              <div className="mb-2">
                <label>Ticket Price</label>
                <input
                  type="number"
                  value={price}
                  placeholder="Ticket Price"
                  onChange={(e) => setprice(e.target.value)}
                  className="form-control form-control-sm"
                />
              </div>
              <div className="mb-2">
                <label>Time Slot</label>
                <select
                  className="form-control form-control-sm"
                  value={slot}
                  onChange={(e) => setslot(e.target.value)}
                >
                  <option value="">Select Time Slot</option>
                  <option value="1">09:00AM to 12:00PM</option>
                  <option value="2">12:00PM to 03:00PM</option>
                  <option value="3">03:00PM to 06:00PM</option>
                  <option value="4">06:00PM to 09:00PM</option>
                  <option value="5">09:00PM to 12:00AM</option>
                </select>
              </div>
              <div className="mb-2">
                <label>From Date</label>
                <input
                  type="date"
                  min={format(new Date(), "yyyy-MM-dd")}
                  className="form-control form-control-sm"
                  value={movieShowStartDate}
                  onChange={(e) => setMovieShowStartDate(e.target.value)}
                />
              </div>
              <div className="mb-2">
                <label>To Date</label>
                <input
                  type="date"
                  min={format(new Date(), "yyyy-MM-dd")}
                  className="form-control form-control-sm"
                  value={movieShowEndDate}
                  onChange={(e) => setMovieShowEndDate(e.target.value)}
                />
              </div>
              <button
                onClick={handleSubmit}
                className="btn btn-primary btn-sm float-end"
              >
                Save Details
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}
