import axios from "axios";
import { useEffect, useState } from "react";
import Swal from "sweetalert2";
import { apiUrls, baseUrl } from "../lib/constants";

const Bookings = () => {
  const [data, setData] = useState([]);

  const handleCancel = (id) => {
    axios
      .delete(baseUrl + apiUrls.BOOKINGS_URL + '/'+ id)
      .then((resp) => {
        Swal.fire({ title: resp.data });
        loadData();
      })
      .catch((error) => {
        Swal.fire({
          icon: "error",
          title: "Error",
          text: "Failed to cancel booking",
        });
      });
  };

  const loadData = () => {
    axios
      .get(baseUrl + apiUrls.BOOKINGS_URL)
      .then((resp) => {
        setData(resp.data);
      })
      .catch((error) => {
        console.error("Error loading bookings:", error);
        Swal.fire({
          icon: "error",
          title: "Error",
          text: "Failed to load bookings",
        });
      });
  };

  useEffect(() => {
    loadData();
  }, []);

  return (
    <div className="container mt-5">
      <h5 className="p-2">All Bookings</h5>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Booking Date</th>
            <th>Movie Name</th>
            <th>User Name</th>
            <th>No of Seats</th>
            <th>Show Date</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {data.map((booking) => (
            <tr key={booking.bookingId}>
              <td>{booking.bookingId}</td>
              <td>{booking.bookDate}</td>
              <td>{booking?.movieShow?.movie?.movieName}</td>
              <td>{booking?.user?.userName}</td>
              <td>{booking.noOfSeats}</td>
              <td>{booking.showDate}</td>
              <td>{booking.state}</td>
              <td>
                {booking.state === "Confirmed" && (
                  <button
                    onClick={() => handleCancel(booking.bookingId)}
                    className="btn btn-danger btn-sm"
                  >
                    Cancel Booking
                  </button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Bookings;
