import axios from "axios";
import { useEffect, useState } from "react";
import swal from "sweetalert2";
import { apiUrls, baseUrl } from "../lib/constants";

const Movies = () => {
  const [data, setData] = useState([]);
  const [movieName, setMovieName] = useState("");
  const [actor, setActor] = useState("");
  const [actress, setActress] = useState("");
  const [director, setDirector] = useState("");
  const [description, setDescription] = useState("");
  const [year, setYear] = useState("");
  const [movieId, setMovieId] = useState(0);
  const [selectedPhoto, setSelectedPhoto] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (
      !movieName ||
      !year ||
      !description ||
      !actor ||
      !actress ||
      !director
    ) {
      swal.fire({
        title: "Error",
        icon: "error",
        text: "Please fill all details",
      });
      return;
    }

    const formData = new FormData();
    formData.append("photo", selectedPhoto);
    formData.append("movieName", movieName);
    formData.append("year", year);
    formData.append("actor", actor);
    formData.append("actress", actress);
    formData.append("director", director);
    formData.append("description", description);
    formData.append("movieId", movieId);

    try {
      const resp = await axios.post(baseUrl + apiUrls.MOVIES_URL, formData);
      swal.fire({
        title: "Success",
        text: resp.data,
      });
      setMovieName("");
      setActor("");
      setActress("");
      setDirector("");
      setYear("");
      setDescription("");
      setMovieId(0);
      setSelectedPhoto(null);
      loadData();
    } catch (err) {
      swal.fire({
        title: "error",
        icon: "error",
        text: "Cannot save Movie",
      });
    }
  };

  const handleEdit = (movie) => {
    setMovieName(movie.movieName);
    setYear(movie.year);
    setActor(movie.actor);
    setActress(movie.actress);
    setDirector(movie.director);
    setDescription(movie.description);
    setMovieId(movie.movieId);
  };

  const handleDelete = async (id) => {
    try {
      const resp = await axios.delete(baseUrl + apiUrls.MOVIES_URL + '/'+ id);
      swal.fire({
        icon: "error",
        title: "Deleted",
        text: resp.data,
      });
      loadData();
    } catch (err) {
      swal.fire({
        title: "Error",
        icon: "error",
        text: "Cannot delete flight",
      });
    }
  };

  const handleFileInput = (e) => {
    setSelectedPhoto(e.target.files[0]);
  };

  const loadData = async () => {
    try {
      const resp = await axios.get(baseUrl + apiUrls.MOVIES_URL);
      setData(resp.data);
    } catch (err) {
      console.error("Error loading data:", err);
    }
  };

  useEffect(() => {
    loadData();
  }, []);

  return (
    <div className="container mt-5">
      <div className="row">
        <div className="col-sm-8">
          <h5 className="p-2">Movies List</h5>
          <table className="table table-bordered">
            <thead>
              <tr>
                <th>Id</th>
                <th>Movie Name</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {data.map((x) => (
                <tr key={x.movieId}>
                  <td>{x.movieId}</td>
                  <td>
                    <img
                      className="float-start"
                      src={"http://localhost:8080/" + x.poster}
                      style={{
                        width: "100px",
                        height: "120px",
                        marginRight: "10px",
                      }}
                      alt={x.movieName}
                    />
                    {x.movieName}
                    <br />
                    Actors: {x.actor}
                    <br />
                    Actress: {x.actress}
                  </td>
                  <td>
                    <button
                      onClick={() => handleDelete(x.movieId)}
                      className="btn btn-danger btn-sm"
                    >
                      Delete
                    </button>
                    <button
                      onClick={() => handleEdit(x)}
                      className="btn btn-primary btn-sm ms-2"
                    >
                      Edit
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div className="col-sm-4">
          <h5>Add Movie</h5>
          <form onSubmit={handleSubmit}>
            <div className="mb-2">
              <label>Movie Name</label>
              <input
                type="text"
                className="form-control form-control-sm"
                value={movieName}
                onChange={(e) => setMovieName(e.target.value)}
              />
            </div>
            <div className="mb-2">
              <label>Actors Name</label>
              <input
                type="text"
                className="form-control form-control-sm"
                value={actor}
                onChange={(e) => setActor(e.target.value)}
              />
            </div>
            <div className="mb-2">
              <label>Actresses Name</label>
              <input
                type="text"
                className="form-control form-control-sm"
                value={actress}
                onChange={(e) => setActress(e.target.value)}
              />
            </div>
            <div className="mb-2">
              <label>Director Name</label>
              <input
                type="text"
                className="form-control form-control-sm"
                value={director}
                onChange={(e) => setDirector(e.target.value)}
              />
            </div>
            <div className="mb-2">
              <label>Release year</label>
              <input
                type="number"
                className="form-control form-control-sm"
                value={year}
                onChange={(e) => setYear(e.target.value)}
              />
            </div>
            <div className="mb-2">
              <label>Description</label>
              <textarea
                rows={3}
                className="form-control form-control-sm"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
              ></textarea>
            </div>
            <div className="mb-2">
              <label>Movie Poster</label>
              <input
                type="file"
                onChange={handleFileInput}
                className="form-control-file form-control"
              />
            </div>
            <div class="centre">
            <button 
              type="submit"
              className="btn btn-primary btn-sm float-end"
            >
              Save Details
            </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Movies;