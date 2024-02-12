import { Link } from "react-router-dom";
import "font-awesome/css/font-awesome.min.css";
import "./Footer.css";
export default function Footer() {
  return (
    <footer
      className="Footer stick-bottom  text-center text-white mx-auto"
      style={{ background: "#272829", width: "100%" }}
    >
      <div className="container-fluid p-1">
        <a
          className="btn btn-outline-light btn-floating m-2"
          href="https://www.facebook.com/login.php"
          type="button"
        >
          <i className="fa fa-facebook-f"></i>
        </a>

        <a
          className="btn btn-outline-light btn-floating m-2"
          href="https://twitter.com/login/"
          type="button"
        >
          <i className="fa fa-twitter"></i>
        </a>

        <a
          className="btn btn-outline-light btn-floating m-2"
          href="https://myaccount.google.com/"
          Type="button"
        >
          <i className="fa fa-google"></i>
        </a>

        <a
          className="btn btn-outline-light btn-floating m-2"
          href="https://www.instagram.com/"
          type="button"
        >
          <i className="fa fa-instagram"></i>
        </a>
      </div>
      <div>
        <h2>Ticket Booking</h2>
        <p>For queries, mail us : multiplex@gmail.com</p>
      </div>

      <div className="text-center p-1">©2024 Copyright by Ticket Booking</div>
      <br />
    </footer>
  );
}
