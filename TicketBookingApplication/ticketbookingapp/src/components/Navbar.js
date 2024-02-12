import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate, useLocation } from "react-router-dom";

export default function Navbar() {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const location = useLocation();

  const logout = (e) => {
    dispatch({ type: "LogOut" });
    sessionStorage.clear();
    navigate("/home");
  };

  const state = useSelector((state) => state);
  console.log("LoggedIn: ", state.loggedin.IsLoggedIn);
  console.log("Role in sessionStorage: ", sessionStorage.getItem("role"));
  
  const isadmin =
    state.loggedin.IsLoggedIn && sessionStorage.getItem("role") === "Admin"
      ? true
      : false;
  const isuser =
    state.loggedin.IsLoggedIn && sessionStorage.getItem("role") === "User"
      ? true
      : false;
  
  console.log("isAdmin: ", isadmin);
  console.log("isUser: ", isuser);

  const isHomePage = location.pathname === "/home";
  // const isLogin = location.pathname === "/clogin";
  // const isRegister = location.pathname === "/cregister";
  // const isLogRegister = location.pathname === "/loginreg";

  // Render nothing if it's the home page
  if (isHomePage ) {
    return null;
  }

  // if(isLogin || isRegister){
  //   return (
  //     <div>
  //       <nav
  //         className="navbar fixed-top navbar-expand-lg  "
  //         style={{padding: "5px 10px", background: "#272829",borderRadius: "15px",overflow: "hidden" }}
  //       >
  //         <div className="container-fluid" >
  //           <Link to="/">
  //             <img src="/download.gif" alt="Logo" style={{ height: 50 }} />
  //           </Link>
  //           </div>
  //           </nav>
  //           </div>
  //   )
  // }
  
  return (
    <div>
      <nav
        className="navbar fixed-top navbar-expand-lg  "
        style={{padding: "5px 10px", background: "#000000",borderRadius: "15px",overflow: "hidden" }}
      >
        <div className="container-fluid" >
          {/* <Link className="navbar-brand" to="#" style={{
            color:"red",
    border: "none",
    fontWeight: "bold",
    color: "white",
    textShadow: "0px 0px 5px rgba(0, 0, 0, 0.5)",
    transition: "text-shadow 0.3s ease",
    background: "transparent"
  }}
  onMouseOver={(e) => e.target.style.textShadow = "0px 0px 15px rgba(0, 0, 0, 0.7)"}
  onMouseOut={(e) => e.target.style.textShadow = "0px 0px 100px rgba(0, 0, 0, 0)"}
>
          Ticket Booking
          </Link> */}
          <Link to="/home">
            <img src="/download1.gif" alt="Logo" style={{ height: 50 }} />
          </Link>
          {/* <button
            className="btn btn-sm btn-outline-secondary"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button> */}
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className="nav-link active" aria-current="page" to="/">
                <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>Home</button>
                </Link>
              </li>
              {isadmin ? (
                <>
                  <li className="nav-item">
                    <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/users"
                    >
                      <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>User</button>
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/movies"
                    >
                      <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>Movies</button>
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/theatres"
                    >
                      <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>Theatres</button>
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/shows"
                    >
                      <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>Shows</button>
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/bookings"
                    >
                      <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>Bookings</button>
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/reports"
                    >
                      <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>Report</button>
                    </Link>
                  </li>
                </>
              ) : (
                ""
              )}
              {isuser ? (
                <>
                  <li className="nav-item">
                    <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/mybookings"
                    >
                      <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>Bookings</button>
                    </Link>
                  </li>
                </>
              ) : null}
              {!state.loggedin.IsLoggedIn ? (
                <>
                  {/* <li className="nav-item">
                    <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/clogin"
                    >
                    <button type="button" class="btn btn-dark">Login</button>

                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/cregister"
                    >
                      <button type="button" class="btn btn-dark">Register</button>
                    </Link> */}
                    {/* <Link
                      className="nav-link active"
                      aria-current="page"
                      to="/register"
                    >
                      <button type="button" class="btn btn-dark">Register</button>
                    </Link> */}
                  {/* </li> */}
                </>
              ) : (
                <>
                  <li className="nav-item">
                    <Link
                      to="/profile"
                      className="nav-link active"
                      aria-current="page"
                    >
                      <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>
                      Hi! {state.loggedin.Username}</button>
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link
                      to="/"
                      className="nav-link active"
                      aria-current="page"
                      onClick={logout}
                    >
                      <button type="button" class="btn btn-dark" style={{ backgroundColor: "#000000", color: "#ffffff", border: "none"}}>LogOut</button>
                    </Link>
                  </li>
                </>
              )}
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
}
