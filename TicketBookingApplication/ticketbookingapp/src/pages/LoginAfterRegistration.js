import React, {useState, } from 'react'
import Button from '@mui/material/Button';
import Avatar from '@mui/material/Avatar';
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
import {useNavigate, } from 'react-router-dom';
import { validateUser } from './UserService';
import * as yup from 'yup' // importing functions from yup library
 
 
 
 
 
function Copyright(props) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link style={{ color: '#DF3E3E' }} color='#FFFFFF'>
        mbs.co.in
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}
 
export default function LoginRegForm() {
  const [emailId, setEmailId] = useState('')
  const [password, setPassword] = useState('')
  const [errors, setErrors] = useState({})
  const [generalError, setGeneralError] = useState('');
  const navigate = useNavigate();
 
  const userSchema = yup.object().shape({
    emailId: yup.string().email().required(),
    password: yup.string().min(6).max(50).required()
  })
 
  const handleSubmit = async (e) => {
    e.preventDefault();
    const signinuser = { emailId, password };
    console.log(signinuser);
 
    try {
      await userSchema.validate(signinuser, { abortEarly: false });
 
      validateUser(signinuser).then(response => {console.log("User signed in: ",response.data);
       navigate('/hometwo');
      }).catch(error => {
        // Handle backend errors
        if (error.response && error.response.status === 400) {
          const { data } = error.response;
          if (data.includes('email') || data.includes('password')) {
            setGeneralError('Invalid username or password'); // Set general error message
          }
        } else {
          console.error('Error signing user:', error);
          alert(error);
        }
      });
     
    } catch (error) {
      if (error instanceof yup.ValidationError) {
        const validationErrors = {};
        error.inner.forEach((e) => {
          validationErrors[e.path] = e.message;
        });
        setErrors(validationErrors);
      } else {
        console.error('Error signing user:', error);
        alert(error);
      }
    }
  };
 
  return (
    <ThemeProvider theme={createTheme({
      palette: { mode: 'dark' },
       })}>
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
            Sign in
          </Typography>
          <p>Registered Successfully. Sign in to your Account</p>
          {generalError && (
            <Typography color="error" align="center" variant="body2" gutterBottom>
              {generalError}
              </Typography>
          )}
          <Box component="form" onSubmit={handleSubmit} sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="emailId"
              label="Email Address"
              name="emailId"
              type="email"
              value={emailId}
              onChange={(e) => setEmailId(e.target.value)}
              autoComplete="email"
              autoFocus
              error={!!errors.emailId} // Add error prop
              helperText={errors.emailId}
            />
            {/* {errors.emailId && (
              <div style={{ color: 'red', fontSize: '0.7rem' }}>{errors.emailId}</div>
            )} */}
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              autoComplete="current-password"
              error={!!errors.password}
              helperText={errors.password}
            />
            {/* {errors.password && (
              <div style={{ color: 'red', fontSize: '0.8rem' }}>{errors.password}</div>
            )} */}
            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="Remember me"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2, backgroundColor: '#FF0000', color: 'black', '&:hover': {
                backgroundColor: '#DF3E3E', // Change the background color on hover
              }}}
            >
              Sign In
            </Button>
            <Grid container justifyContent="center">
              <Grid item>
              <Link to="/register" variant="body2" style={{ color: '#DF3E3E' }}>
                  {"Don't have an account? Sign Up"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
        <Copyright sx={{ mt: 8, mb: 4 }} />
      </Container>
      </Box>
    </ThemeProvider>
  );
}