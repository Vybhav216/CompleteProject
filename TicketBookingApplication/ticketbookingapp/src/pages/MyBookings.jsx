import axios from "axios";
import { useEffect, useState } from "react";
import Swal from "sweetalert2";
import { apiUrls, baseUrl } from "../lib/constants";
import { findslot, formatDate } from "../lib/util";

export default function MyBookings() {
  const [data, setData] = useState([]);

  const handleCancel = (id) => {
    Swal.fire({
      title: "Are you sure?",
      text: "This action cannot be undone.",
      icon: "warning",
      showCancelButton: true,
      confirmButtonText: "Yes, cancel it!",
      cancelButtonText: "No, keep it",
    }).then((result) => {
      if (result.isConfirmed) {
        axios.get(baseUrl + apiUrls.CANCELLED_BOOKING + '/' + id)
          .then((resp) => {
            Swal.fire({ title: resp.data });
            loadData();
          })
          .catch((error) => {
            Swal.fire({
              icon: "error",
              title: "Oops...",
              text: error.response?.data || "Something went wrong!",
            });
          });
      }
    });
  };



  const loadData = async() => {
    try{
      axios
      .get(
        baseUrl+apiUrls.USERS_BOOKINGS +
          sessionStorage.getItem('id')
      )
      .then((resp) => {
        setData(resp.data)
      })
    }catch(error)  {
        console.log("hello" + error);
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: error.response?.data || "Failed to fetch booking history!",
        });
      };
  };

  useEffect(() => {
    loadData();
  }, []);

  return (
    <div className="container mt-5">
      <h5 className="p-2">Booking History</h5>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Booking Date</th>
            <th>Movie</th>
            <th>No of Seats</th>
            <th>Cost</th>
            <th>Movie Show Date</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {data.map((x) => (
            <tr key={x?.bookingId}>
              <td>{x?.bookingId}</td>
              <td>{x?.bookDate}</td>
              <td>
                <img
                  className="float-start me-2"
                  src={baseUrl + x?.movieShow?.movie?.poster}
                  style={{ width: "100px", height: "100px" }}
                  alt={x?.movieShow?.movie?.movieName}
                />
                <div>
                  <strong>{x?.movieShow?.movie?.movieName}</strong>
                  <br />
                  ({x?.movieShow?.movie?.year})<br />
                  {x?.movieShow?.movie?.actor}
                  <br />
                  {x?.movieShow?.movie?.director}
                </div>
              </td>
              <td>{x?.noOfSeats}</td>
              <td>{x?.cost}</td>
              <td>
                {(x?.movieShowDate)}
                <br />
                {findslot(x?.movieShow?.slot)}
              </td>
              <td>{x?.state}</td>
              <td>
                {x?.state === "Confirmed" && (
                  <button
                    onClick={() => handleCancel(x?.bookingId)}
                    className="btn btn-danger btn-sm"
                  >
                    Cancel
                  </button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
