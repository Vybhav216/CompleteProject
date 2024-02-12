// import { format, parse } from "date-fns";
// import { useSelector } from "react-redux";
// import { Link } from "react-router-dom";
// import { baseUrl } from "../lib/constants";

// export default function SearchResult(props) {
//   const data = props.data;
//   const state = useSelector((state) => state);
//   const isLoggedIn = state.loggedin.IsLoggedIn;
//   const userRole = sessionStorage.getItem("role");
//   const isUser = isLoggedIn && userRole === "User";

//   const findSlot = (id) => {
//     switch (id) {
//       case 1:
//         return "09:00AM to 12:00PM";
//       case 2:
//         return "12:00PM to 03:00PM";
//       case 3:
//         return "03:00PM to 06:00PM";
//       case 4:
//         return "06:00PM to 09:00PM";
//       case 5:
//         return "09:00PM to 12:00PM";
//       default:
//         return "";
//     }
//   };

//   return (
//     <div className="mx-auto my-2 bg-white" style={{ width: "95%" }}>
//       <h5 className="p-2 text-center">Movies List</h5>
//       {data.length > 0 ? (
//         <table className="table table-bordered table-responsive">
//           <thead>
//             <tr>
//               <th>Movie Name</th>
//               <th>Slot</th>
//               <th>Theatre Details</th>
//               <th>Date</th>
//               <th>Action</th>
//             </tr>
//           </thead>
//           <tbody>
//             {data.map((x) => (
//               <tr key={x.movieShowId}>
//                 <td>
//                   <img
//                     style={{
//                       width: "80px",
//                       height: "100px",
//                       marginRight: "10px",
//                     }}
//                     src={baseUrl + x.movie.poster}
//                     alt={x.movie.movieName}
//                   />
//                   {x.movie.movieName}
//                 </td>
//                 <td>{findSlot(x.slot)}</td>
//                 <td>{x.theatre.theatreDesc}</td>
//                 <td>
//                   {format(
//                     parse(x.movieShowStartDate, "yyyy-MM-dd", new Date()),
//                     "dd-MMM-yyyy"
//                   )}
//                   -
//                   {format(
//                     parse(x.movieShowEndDate, "yyyy-MM-dd", new Date()),
//                     "dd-MMM-yyyy"
//                   )}
//                 </td>
//                 <td>
//                   {isUser && (
//                     <Link
//                       to={"book/" + x.movieShowId}
//                       className="btn btn-danger btn-sm"
//                     >
//                       Book Now
//                     </Link>
//                   )}
//                 </td>
//               </tr>
//             ))}
//           </tbody>
//         </table>
//       ) : (
//         <h5 className="text-center p-2">No movies found</h5>
//       )}
//     </div>
//   );
// }


















import { useState, useEffect } from "react";
import { format, parse } from "date-fns";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { baseUrl } from "../lib/constants";
 
export default function SearchResult(props) {
  const initialData = props.data;
  const [data, setData] = useState(initialData);
  const state = useSelector((state) => state);
  const isLoggedIn = state.loggedin.IsLoggedIn;
  const userRole = sessionStorage.getItem("role");
  const isAdmin = isLoggedIn && userRole === "Admin";
  const isUser = isLoggedIn && userRole === "User";
 
  const findSlot = (id) => {
    switch (id) {
      case 1:
        return "09:00AM to 12:00PM";
      case 2:
        return "12:00PM to 03:00PM";
      case 3:
        return "03:00PM to 06:00PM";
      case 4:
        return "06:00PM to 09:00PM";
      case 5:
        return "09:00PM to 12:00PM";
      default:
        return "";
    }
  };
 
  useEffect(() => {
    setData(initialData);
  }, [initialData]);
 
  return (
    <div className="d-flex flex-wrap justify-content-around mx-auto my-2">
      {data.length > 0 ? (
        data.map((x) => (
          <div key={x.movieShowId} className="card m-2 hover-card" style={{ width: "18rem", backgroundColor: "#000", color: "#fff", transition: "transform 0.3s", cursor: "pointer" }} onMouseOver={(e) => e.currentTarget.style.transform = "scale(1.05)"} onMouseOut={(e) => e.currentTarget.style.transform = "scale(1)"}>
            <div className="card-img-top" style={{ backgroundImage: `url(${baseUrl + x.movie.poster})`, height: "200px", backgroundSize: "cover", backgroundPosition: "center" }}></div>
            <div className="card-body">
              <h5 className="card-title">
                {x.movie.movieName}
              </h5>
              <p className="card-text">Slot: <span style={{ fontWeight: "bold" }}>{findSlot(x.slot)}</span></p>
              <p className="card-text">Theatre: {x.theatre.theatreDesc}</p>
              <p className="card-text">
                Date: {format(parse(x.movieShowStartDate, "yyyy-MM-dd", new Date()), "dd-MMM-yyyy")} - {format(parse(x.movieShowEndDate, "yyyy-MM-dd", new Date()), "dd-MMM-yyyy")}
              </p>
              {isUser && (
                <Link to={"book/" + x.movieShowId} className="btn btn-danger btn-sm hover-btn" style={{ backgroundColor: "#ffcc00", border: "none", transition: "transform 0.3s" }}>
                  Book Now
                </Link>
              )}
              {isAdmin && (
                <p className="text-muted"></p>
              )}
            </div>
          </div>
        ))
      ) : (
        <h5 className="text-center p-2" style={{ color: "#fff" }}>No movies found</h5>
      )}
    </div>
  );
}


