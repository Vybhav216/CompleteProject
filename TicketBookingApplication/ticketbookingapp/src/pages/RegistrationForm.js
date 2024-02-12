import React, {useState, } from 'react'
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
import { registerUser } from './UserService';
import {useNavigate, } from 'react-router-dom';
import * as yup from 'yup' // importing functions from yup library
 
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
 
export default function RegistrationForm() {
  const [userName, setUserName] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [errors, setErrors] = useState({})
  const [admin] = useState(false)
  const navigate = useNavigate();
 
  const userSchema = yup.object().shape({
    userName: yup.string().min(3).max(50).required(),
    email: yup.string().email().required(),
    password: yup.string().min(6).max(50).required()
  })
 
  const handleSubmit = async (e) => {
    e.preventDefault();
   
    const reguser = { userName, email, password, admin };
    console.log(reguser);
 
    try {
      await userSchema.validate(reguser, { abortEarly: false });
      registerUser(reguser).then(response => {console.log("User registered ", response.data);
       navigate('/loginreg');
      })
    } catch (error) {
      if (error instanceof yup.ValidationError) {
        const validationErrors = {};
        error.inner.forEach((e) => {
          validationErrors[e.path] = e.message;
        });
        setErrors(validationErrors);
      } else {
        console.error('Error signing up the user:', error);
        alert(error);
      }
    }
  };
 
  return (
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
          <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
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
                  error={!!errors.userName} // Add error prop
                  helperText={errors.userName}
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
                  error={!!errors.emailId} // Add error prop
                  helperText={errors.emailId}
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
                  error={!!errors.password}
                  helperText={errors.password}
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
              <Link to="/login" variant="body2" style={{ color: '#DF3E3E' }}>
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