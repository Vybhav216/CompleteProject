import axios from 'axios'
 
//const CODER_BASE_REST_API_URL = 'http://localhost:8080/api/';
 
export const registerUser = (reguser) => {
    return axios.post('http://localhost:8080/api/users/register', reguser)
};
 
export const validateUser = (signinuser) => {
    return axios.post('http://localhost:8080/api/users/validate', signinuser)
}
 
// export const listAllUsers = () => {
//     return axios.get('http://localhost:8080/api/users/listallusers',user)
// };
 
// export const findUserDetails = (userid) => {
//     return axios.get('http://localhost:8080/api/users/' + userid);
// }
 