import axios from "axios";
import { useEffect, useState } from "react";
import { apiUrls, baseUrl } from "../lib/constants";
import { formatDate } from "../lib/util"; // Import a utility function for date formatting if available

export default function Reports() {
  const [data, setData] = useState([]);

  const loadData = () => {
    axios
      .get(baseUrl + apiUrls.BOOKINGS_URL)
      .then((resp) => {
        setData(resp.data);
      })
      .catch((error) => {
        console.error("Error loading data:", error);
        // Handle error gracefully, such as displaying a message to the user
      });
  };

  useEffect(() => {
    loadData();
  }, []);

  return (
    <div className="container mt-5">
      <h5 className="p-2">Reports</h5>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Booking Date</th>
            <th>User Name</th>
            <th>No of Seats</th>
            <th>Show Date</th>
            <th>Cost</th>
          </tr>
        </thead>
        <tbody>
          {data.map((x) => (
            <tr key={x?.bookingId}>
              <td>{x?.bookingId}</td>
              <td>{x?.bookDate}</td> {/* Format booking date */}
              <td>{x?.user?.userName}</td>
              <td>{x?.noOfSeats}</td>
              <td>{x?.showDate}</td> {/* Format show date */}
              <td>{x?.cost}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
