export default function ShowCase() {
  return (
    <ul className="ShowCase mt-5">
      <li>
        <span className="seat" /> <small>Available</small>
      </li>
      <li>
        <span className="seat selected" /> <small>Selected</small>
      </li>
      <li>
        <span className="seat occupied" /> <small>Booked</small>
      </li>
    </ul>
  );
}
