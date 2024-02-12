import React from 'react';
import { render, screen, waitFor, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import axios from 'axios';
import { MemoryRouter } from 'react-router-dom';
import MyBookings from '../pages/MyBookings';

jest.mock('axios');

describe('MyBookings component', () => {
  test('renders table headers', async () => {
    const mockData = [
      {
        bookingId: 1,
        bookDate: '2024-02-12',
        movieShow: {
          movie: {
            poster: 'movie_poster_url',
            movieName: 'Movie Name',
            year: '2022',
            actor: 'Actor Name',
            director: 'Director Name',
          },
          slot: 'Morning',
        },
        noOfSeats: 2,
        cost: 20,
        movieShowDate: '2024-02-13',
        state: 'Confirmed',
      },
    ];

    axios.get.mockResolvedValueOnce({ data: mockData });

    render(
      <MemoryRouter>
        <MyBookings />
      </MemoryRouter>
    );

    await waitFor(() => {
      expect(screen.getByText('Booking History')).toBeInTheDocument();
      expect(screen.getByText('Id')).toBeInTheDocument();
      expect(screen.getByText('Booking Date')).toBeInTheDocument();
      expect(screen.getByText('Movie')).toBeInTheDocument();
      expect(screen.getByText('No of Seats')).toBeInTheDocument();
      expect(screen.getByText('Cost')).toBeInTheDocument();
      expect(screen.getByText('Movie Show Date')).toBeInTheDocument();
      expect(screen.getByText('Status')).toBeInTheDocument();
      expect(screen.getByText('Action')).toBeInTheDocument();
    });
  });

  test('displays booking details', async () => {
    const mockData = [
      {
        bookingId: 1,
        bookDate: '2024-02-12',
        movieShow: {
          movie: {
            poster: 'movie_poster_url',
            movieName: 'Movie Name',
            year: '2022',
            actor: 'Actor Name',
            director: 'Director Name',
          },
          slot: 'Morning',
        },
        noOfSeats: 2,
        cost: 20,
        movieShowDate: '2024-02-13',
        state: 'Confirmed',
      },
    ];

    axios.get.mockResolvedValueOnce({ data: mockData });

    render(
      <MemoryRouter>
        <MyBookings />
      </MemoryRouter>
    );

    await waitFor(() => {
      expect(screen.getByText('Movie Name')).toBeInTheDocument();
      expect(screen.getByText('Actor Name')).toBeInTheDocument();
      expect(screen.getByText('Director Name')).toBeInTheDocument();
      expect(screen.getByText('2')).toBeInTheDocument();
      expect(screen.getByText('20')).toBeInTheDocument();
      expect(screen.getByText('2024-02-13')).toBeInTheDocument();
      expect(screen.getByText('Confirmed')).toBeInTheDocument();
    });
  });

  test('cancels booking when cancel button is clicked', async () => {
    const mockData = [
      {
        bookingId: 1,
        bookDate: '2024-02-12',
        movieShow: {
          movie: {
            poster: 'movie_poster_url',
            movieName: 'Movie Name',
            year: '2022',
            actor: 'Actor Name',
            director: 'Director Name',
          },
          slot: 'Morning',
        },
        noOfSeats: 2,
        cost: 20,
        movieShowDate: '2024-02-13',
        state: 'Confirmed',
      },
    ];

    axios.get.mockResolvedValueOnce({ data: mockData });
    axios.delete.mockResolvedValueOnce({ data: 'Booking cancelled successfully' });

    render(
      <MemoryRouter>
        <MyBookings />
      </MemoryRouter>
    );

    await waitFor(() => {
      fireEvent.click(screen.getByText('Cancel'));
    });

    await waitFor(() => {
      expect(screen.getByText('Booking cancelled successfully')).toBeInTheDocument();
    });
  });
});
