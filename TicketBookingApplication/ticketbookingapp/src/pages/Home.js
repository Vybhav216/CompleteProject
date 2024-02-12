import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';
import Typography from '@mui/material/Typography';
import MovieIcon from '@mui/icons-material/Movie';
import MoneyIcon from '@mui/icons-material/Money';
import FastfoodIcon from '@mui/icons-material/Fastfood';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
 
 
const Homepage = () => {
  return (
    <>
      {/* Navbar */}
      <AppBar position="static" sx={{ bgcolor: '#000000' }}>
        <Toolbar sx={{ display: 'flex', justifyContent: 'space-between' }}>
          <Link to="/home">
            <img src="/download1.gif" alt="Logo" style={{ height: 50 }} />
          </Link>
          <div>
  <Button
    variant="text"
    component={Link}
    to="/clogin"
    sx={{ mr: 1, color: '#FFFFFF' }}
  >
    Sign In
  </Button>
  <Button
    variant="text"
    component={Link}
    to="/cregister"
    sx={{ color: '#DF3E3E' }}
  >
    Sign Up
  </Button>
</div>
        </Toolbar>
      </AppBar>
 
      {/* Main Content Section */}
      {/* <section style={{ position: 'relative', backgroundColor: '#000000', color: '#FFFFFF', padding: '6px 0', textAlign: 'center' }}>
        <div style={{ maxWidth: '100%', margin: '0 auto', textAlign: 'center' }}>
          <img src="/images/mainimage.jpg" alt="Main" style={{ maxWidth: '100%', height: 'auto', borderRadius: '10px', marginBottom: '20px' }} />
          <div style={{ position: 'absolute', top: '50%', left: '50%', transform: 'translate(-50%, -50%)', zIndex: '1' }}>
            <Typography variant="h3" sx={{ fontFamily: 'Roboto', marginBottom: '10px' }}>Welcome to Mooovi Booking</Typography>
            <Typography variant="h5" sx={{ fontFamily: 'Roboto', marginBottom: '20px' }}>Book your Tickets to Entertainment</Typography>
          <Button variant="contained" component={Link} to="/register" sx={{ bgcolor: '#DF3E3E', color: '#FFFFFF', marginTop: '20px', borderRadius: '0px', fontSize: '14px', padding: '15px 50px', '&:hover': { bgcolor: '#DF3E3E', boxShadow: '0px 5px 15px rgba(0, 0, 0, 0.3)' }  }}>
            Register
          </Button>
          </div>
        </div>
      </section> */}
      {/* Main Content Section */}
<section style={{ position: 'relative', backgroundColor: '#000000', color: '#FFFFFF', padding: '6px 0', textAlign: 'center' }}>
  <div style={{ maxWidth: '100%', margin: '0 auto', textAlign: 'center' }}>
    <Slider
      dots={true}  // Add dots for navigation
      infinite={true} // Enable infinite loop
      speed={1000} // Animation speed
      slidesToShow={1} // Number of slides to show at a time
      slidesToScroll={1} // Number of slides to scroll at a time
      autoplay={true} // Autoplay slides
      autoplaySpeed={1000} // Autoplay speed in milliseconds
    >
      <div>
        <img src="/mainimage.jpg" alt="Main 1" style={{ maxWidth: '100%', height: 'auto', borderRadius: '10px', marginBottom: '20px' }} />
      </div>
      <div>
        <img src="/mainimage1.jpg" alt="Main 1" style={{ maxWidth: '100%', height: 'auto', borderRadius: '10px', marginBottom: '20px' }} />
      </div>
      <div>
        <img src="/mainimage2.jpg" alt="Main 1" style={{ maxWidth: '100%', height: 'auto', borderRadius: '10px', marginBottom: '20px' }} />
      </div>
      <div>
        <img src="/mainimage3.jpg" alt="Main 2" style={{ maxWidth: '100%', height: 'auto', borderRadius: '10px', marginBottom: '20px' }} />
      </div>
      <div>
        <img src="/mainimage4.jpg" alt="Main 3" style={{ maxWidth: '100%', height: 'auto', borderRadius: '10px', marginBottom: '20px' }} />
      </div>
      <div>
        <img src="/mainimage5.jpg" alt="Main 3" style={{ maxWidth: '100%', height: 'auto', borderRadius: '10px', marginBottom: '20px' }} />
      </div>
    </Slider>
    <div style={{ position: 'absolute', top: '50%', left: '50%', transform: 'translate(-50%, -50%)', zIndex: '1' }}>
      <Typography variant="h3" sx={{ fontFamily: 'Roboto', marginBottom: '10px' }}>Welcome to Mooovi Booking</Typography>
      <Typography variant="h5" sx={{ fontFamily: 'Roboto', marginBottom: '20px' }}>Book your Tickets to Entertainment</Typography>
      <Button variant="contained" component={Link} to="/cregister" sx={{ bgcolor: '#DF3E3E', color: '#FFFFFF', marginTop: '20px', borderRadius: '0px', fontSize: '14px', padding: '15px 50px', '&:hover': { bgcolor: '#DF3E3E', boxShadow: '0px 5px 15px rgba(0, 0, 0, 0.3)' } }}>
        Register
      </Button>
    </div>
  </div>
</section>
 
 
      {/* Other Sections */}
      <section style={{ backgroundColor: '#EBDBCC', padding: '50px 0', margin: '0' }}>
        <div style={{ display: 'flex', justifyContent: 'space-around', alignItems: 'center', maxWidth: '1200px', margin: '0 auto' }}>
          <div style={{ textAlign: 'center' }}>
            <MovieIcon sx={{ fontSize: 100 }} />
            <Typography variant="h6" gutterBottom>
              Clear Picture
            </Typography>
            <Typography variant="body1">
            Experience crystal-clear visuals with our state-of-the-art screens
            </Typography>
          </div>
          <div style={{ textAlign: 'center' }}>
            <MoneyIcon sx={{ fontSize: 100 }} />
            <Typography variant="h6" gutterBottom>
              Affordable
            </Typography>
            <Typography variant="body1">
            Countless moviegoers have already taken advantage of our budget-friendly rates
            </Typography>
          </div>
          <div style={{ textAlign: 'center' }}>
            <FastfoodIcon sx={{ fontSize: 100 }} />
            <Typography variant="h6" gutterBottom>
              Food Coupons/Offers
            </Typography>
            <Typography variant="body1">
            New deals are released regularly. Save up on your favorite snacks and meals
            </Typography>
          </div>
        </div>
      </section>
 
      {/*Movies Section */}
<section style={{ backgroundColor: '#000000', padding: '50px 0', textAlign: 'center' }}>
  <img src="/MOVIES.jpg" alt="Latest Movies" style={{ maxWidth: '100%' }} />
</section>
 
{/* Contact Form Section */}
<section style={{ backgroundColor: '#262f36', color: '#FFFFFF', padding: '50px 0', textAlign: 'center' }}>
  <Typography variant="h4" gutterBottom>
    Contact Us
  </Typography>
  <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'flex-start' }}>
    {/* Contact Form */}
    <form style={{ flex: '1', maxWidth: '400px', marginRight: '20px', backgroundColor: 'transparent' }}>
      <div style={{ marginBottom: '20px', border: '1px solid #FFFFFF', borderRadius: '1px' }}>
        <input type="text" placeholder="Your Name*" style={{ padding: '10px', width: '100%', borderRadius: '1px', border: 'none', backgroundColor: 'transparent', color: '#FFFFFF' }} />
      </div>
      <div style={{ marginBottom: '20px', border: '1px solid #FFFFFF', borderRadius: '1px' }}>
        <input type="email" placeholder="Your Email*" style={{ padding: '10px', width: '100%', borderRadius: '`1px', border: 'none', backgroundColor: 'transparent', color: '#FFFFFF' }} />
      </div>
      <div style={{ marginBottom: '20px', border: '1px solid #FFFFFF', borderRadius: '1px' }}>
        <textarea placeholder="Your Message*" rows="4" style={{ padding: '10px', width: '100%', borderRadius: '1px', border: 'none', backgroundColor: 'transparent', color: '#FFFFFF' }}></textarea>
      </div>
      <Button variant="contained" sx={{ bgcolor: '#DF3E3E', color: '#FFFFFF', '&:hover': { bgcolor: '#DF3E3E', boxShadow: '0px 5px 15px rgba(0, 0, 0, 0.3)' } }}>
        Submit
      </Button>
    </form>
 
    {/* Image on the right */}
    <div style={{ flex: '1', maxWidth: '400px' }}>
      <img src="/contact_image.jpg" alt="Contact" style={{ width: '100%', height: 'auto', borderRadius: '10px' }} />
    </div>
  </div>
</section>
 
      {/* Footer Section */}
      <footer style={{ backgroundColor: '#000000', padding: '20px 0', textAlign: 'center' }}>
  <Typography variant="body2" color="text.secondary" align="center" sx={{ color: '#FFFFFF' }}>
    {'Copyright © '}
    <Link style={{ color: '#DF3E3E' }}>
      mooovi.co.in
    </Link>{' '}
    {new Date().getFullYear()}
    {'.'}
  </Typography>
</footer>
</>
  );
};
 
export default Homepage;