import axios from "axios";
import { useEffect, useState } from "react";
import { apiUrls, baseUrl } from "../lib/constants";

export default function CustomersList() {
  const [data, setData] = useState([]);
  useEffect(() => {
    axios.get(baseUrl + apiUrls.USERS_LIST).then((resp) => {
      setData(resp.data);
    });
  }, []);

  return (
    <div className="container mt-5">
      <h5 className="p-2">Users List</h5>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email Id</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {data
            .filter((x) => !x.admin) // Filter out admin users
            .map((x) => (
              <tr key={x.userId}>
                <td>{x.userId}</td>
                <td>{x.userName}</td>
                <td>{x.email}</td>
                <td>{x.active ? "Active" : "Inactive"}</td>
              </tr>
            ))}
        </tbody>
      </table>
    </div>
  );
}
