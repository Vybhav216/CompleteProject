export const baseUrl='http://localhost:8080/'

export const apiUrls={
    LOGIN_URL:'api/users/validate',
    REGISTER_URL: 'api/users/register',
    BOOKINGS_URL:'api/bookings',
    SHOWS_URL: 'api/movieShows',
    CHECK_SHOWS_BOOKING_URL: 'api/bookings/check',
    THEATRE_URL: 'api/theatres',
    TODAYS_SHOWS:'api/movieShows/todays',
    SEARCH_SHOWS: 'api/movieShows/search',
    USERS_LIST: 'api/users',
    MOVIES_URL: 'api/movies',
    CANCELLED_BOOKING: 'api/bookings/{id}',
    USERS_BOOKINGS: 'api/bookings?userId=',
    USERS_PAYMENTS: 'api/bookings/payments',
    USER_URL: 'api/users/',
}