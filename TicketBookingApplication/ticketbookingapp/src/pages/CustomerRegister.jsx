import React, { useState } from "react";
import axios from "axios";
import "../components/3.css";
import { useNavigate } from "react-router-dom";
import swal from "sweetalert2";
import { apiUrls, baseUrl } from "../lib/constants";
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { Link } from 'react-router-dom';

export default function CustomerRegister() {
  return (
    <div>
      <CustomerTable />
    </div>
  );
}

function Copyright(props) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link style={{ color: '#DF3E3E' }} color='#FFFFFF'>
        mooovi.co.in
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

function CustomerTable() {
  const navigate = useNavigate();
  // const [fname, setFname] = useState("");
  // const [lname, setLname] = useState("");
  const [userName, setUserName] = useState('')
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleForm = (e) => {
    e.preventDefault();
    if (email === "") {
      swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Please enter valid email!",
      });
    } else if (password === "") {
      swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Please enter password",
      });
    } else if (password.length < 6 || password.length > 15) {
      swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Password length should be between 6 and 15 characters",
      });
    } else {
      submit();
    }
  };

  const submit = async () => {
    try {
      await axios.post(baseUrl + apiUrls.REGISTER_URL, {
        // userName: `${fname} ${lname}`,
        userName: userName,
        email: email,
        password: password,
      });
      swal.fire({
        position: "center",
        icon: "success",
        title: "Registered Successfully",
        showConfirmButton: false,
        timer: 1500,
      });
      navigate("/clogin");
    } catch (error) {
      swal.fire({
        position: "center",
        icon: "error",
        title: error.response.data,
        showConfirmButton: false,
        timer: 1500,
      });
    }
  };

  return (
  //   <div className="container" style={{ color:"black", width: "70%", marginTop: "100px" }}>
  //     <div className="title text-center">User Registration Form</div>
  //     <form>
  //       <div className="user-details">
  //         <div className="input-box">
  //           <span className="details">First Name</span>
  //           <input
  //             type="text"
  //             placeholder="Enter first name"
  //             value={fname}
  //             onChange={(e) => setFname(e.target.value)}
  //             required
  //           />
  //         </div>
  //         <div className="input-box">
  //           <span className="details">Last Name</span>
  //           <input
  //             type="text"
  //             placeholder="Enter last name"
  //             value={lname}
  //             onChange={(e) => setLname(e.target.value)}
  //             required
  //           />
  //         </div>
  //         <div className="input-box">
  //           <span className="details">Email</span>
  //           <input
  //             type="email"
  //             placeholder="Enter your email"
  //             value={email}
  //             onChange={(e) => setEmail(e.target.value)}
  //             required
  //           />
  //         </div>
  //         <div className="input-box">
  //           <span className="details">Password</span>
  //           <input
  //             type="password"
  //             placeholder="Enter your password"
  //             value={password}
  //             onChange={(e) => setPassword(e.target.value)}
  //             required
  //           />
  //         </div>
  //       </div>
  //       <div className="button" style={{ margin: "auto" , borderRadius:50 }}>
  //         <input
  //           type="submit"
  //           className=""
  //           value="Submit"
  //           onClick={handleForm}
  //         />
  //       </div>
  //     </form>
  //   </div>
  // );
  <ThemeProvider theme={createTheme({
    palette: { mode: 'dark' },
    background: { default: '#000000', // Set background color to black
    } })}>
      <Box
    sx={{
      backgroundImage: `url('/bg1.png')`,
      backgroundSize: 'cover',
      backgroundPosition: 'center',
      minHeight: '100vh', // Ensure the background covers the entire viewport
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
    }}
  >
    <Container component="main" maxWidth="xs">
      <CssBaseline />
      <Box
        sx={{
          marginTop: 8,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
          backgroundColor: 'transparent', // Adjust the background color to make the text more readable
          padding: '10px', // Add padding to the box to separate the components from the background edges
          borderRadius: '10px', // Add border radius to the box for better aesthetics
          border: '1px solid rgba(255,255,255,.2)',
          backdropFilter: 'blur(5px)',
          boxShadow: '0 0 20px rgba(0, 0, 0, .2)'
        }}
      >
        <Avatar sx={{ width: 100, height: 100, bgcolor: 'secondary.main' }}>
        <img src="/formlogo.png" alt="Logo" style={{ width: '120%', height: '120%', objectFit: 'cover', borderRadius: '50%', backgroundColor: 'inherit' }} />
        </Avatar>
        <Typography component="h1" variant="h5">
          Sign up
        </Typography>
        <p>Please fill all the details to register your Account</p>
        <Box component="form" onSubmit={handleForm} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField
                autoComplete="given-name"
                name="userName"
                required
                fullWidth
                id="userName"
                label="User Name"
                value={userName}
                onChange={(e) => setUserName(e.target.value)}
                autoFocus
                // error={!!errors.userName} // Add error prop
                // helperText={errors.userName}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                autoComplete="email"
                // error={!!errors.emailId} // Add error prop
                // helperText={errors.emailId}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                autoComplete="new-password"
                // error={!!errors.password}
                // helperText={errors.password}
              />
            </Grid>
            <Grid item xs={12}>
              <FormControlLabel
                control={<Checkbox value="allowExtraEmails" color="primary" />}
                label="I want to receive promotions, offers and updates via email."
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2, backgroundColor: '#FF0000', color: 'black', '&:hover': {
              backgroundColor: '#DF3E3E', // Change the background color on hover
            }}}
          >
            Sign Up
          </Button>
          <Grid container justifyContent="center">
            <Grid item >
            <Link to="/clogin" variant="body2" style={{ color: '#DF3E3E' }}>
                Already have an account? Sign in
              </Link>
            </Grid>
          </Grid>
        </Box>
      </Box>
      <Copyright sx={{ mt: 5 }} />
    </Container>
    </Box>
  </ThemeProvider>
);
}
