import { useEffect, useState } from "react";
import axios from "axios";
import SearchResult from "./SearchResult";
import { apiUrls, baseUrl } from "../lib/constants";
import Swal from "sweetalert2";

export default function Carouselslide() {
  const [theatres, setTheatres] = useState([]);
  const [date, setDate] = useState("");
  const [movieName, setMovieName] = useState("");
  const [slot, setSlot] = useState(0);
  const [theatreId, setTheatreId] = useState(0);
  const [data, setData] = useState([]);

  const handleSearch = (e) => {
    e.preventDefault();
    if (theatreId || date || movieName || slot) {
      axios
        .get(
          baseUrl +
            apiUrls.SEARCH_SHOWS +
            "?theatreid=" +
            theatreId +
            "&date=" +
            date +
            "&movieName=" +
            movieName +
            "&slot=" +
            slot
        )
        .then((resp) => {
          setData(resp.data);
        })
        .catch((error) => {
          console.error("Error searching for shows:", error);
          Swal.fire("Error", "Failed to search for shows", "error");
        });
    } else {
      Swal.fire("Error", "Please select at least one parameter");
    }
  };

  useEffect(() => {
    axios
      .get(baseUrl + apiUrls.THEATRE_URL)
      .then((resp) => {
        setTheatres(resp.data);
      })
      .catch((error) => {
        console.error("Error loading theatres:", error);
        Swal.fire("Error", "Failed to load theatres", "error");
      });

    axios
      .get(baseUrl + apiUrls.TODAYS_SHOWS)
      .then((resp) => {
        setData(resp.data);
      })
      .catch((error) => {
        console.error("Error loading today's shows:", error);
        Swal.fire("Error", "Failed to load today's shows", "error");
      });
  }, []);

  return (
    <>
      <div className="mt-5">
        <div
          className="d-block w-100"
          style={{
            height: "500px",
            backgroundImage: "url('fifth.jpg')",
            //backgroundColor: "3D3B40",
            backgroundSize: "100% 100%",
          }}
        >
          <form
            className="d-block mx-auto"
            style={{
              width: "80%",
              position: "absolute",
              top: "44%",
              left: "50%",
              transform: "translate(-50%,-50%)",
            }}
          >
            <div className="row">
              <div className="col-sm-3">
                <select
                  className="form-control me-2"
                  value={slot}
                  onChange={(e) => setSlot(e.target.value)}
                >
                  <option value="">Select Time Slot</option>
                  <option value="1">09:00AM to 12:00PM</option>
                  <option value="2">12:00PM to 03:00PM</option>
                  <option value="3">03:00PM to 06:00PM</option>
                  <option value="4">06:00PM to 09:00PM</option>
                  <option value="5">09:00PM to 12:00AM</option>
                </select>
              </div>
              <div className="col-sm-2">
                <select
                  className="form-control me-2"
                  value={theatreId}
                  onChange={(e) => setTheatreId(e.target.value)}
                >
                  <option value="">Select Theatres</option>
                  {theatres.map((theatre) => (
                    <option key={theatre.theatreId} value={theatre.theatreId}>
                      {theatre.theatreDesc}
                    </option>
                  ))}
                </select>
              </div>
              <div className="col-sm-3">
                <input
                  type="search"
                  placeholder="Movie name here"
                  className="form-control me-2"
                  value={movieName}
                  onChange={(e) => setMovieName(e.target.value)}
                />
              </div>
              <div className="col-sm-3">
                <input
                  type="date"
                  className="form-control me-2"
                  value={date}
                  onChange={(e) => setDate(e.target.value)}
                />
              </div>
              <div className="col-sm-1">
                <button
                  onClick={handleSearch}
                  className="btn btn-warning bg-gradient text-black"
                  type="submit"
                >
                  <i className="fa fa-search"></i>
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
      <SearchResult data={data} />
    </>
  );
}
