import React from 'react';
import { render, screen, waitFor } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import Bookings from '../pages/Bookings';
 
describe('Bookings Component', () => {
  let mockAxios;
 
  beforeEach(() => {
    mockAxios = new MockAdapter(axios);
  });
 
  afterEach(() => {
    mockAxios.restore();
  });
 
  it('displays error message when bookings fail to load', async () => {
    // Mock the Axios request to simulate a failed response
    mockAxios.onGet('/api/bookings').reply(404);
 
    // Render the component
    render(<Bookings />);
 
    // Wait for the error message to be displayed
    await waitFor(() => {
      expect(screen.getByText('Failed to load bookings')).toBeInTheDocument();
    });
  });
 
});