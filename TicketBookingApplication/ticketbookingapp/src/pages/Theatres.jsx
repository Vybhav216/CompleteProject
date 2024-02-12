// import axios from 'axios'
// import { useEffect, useState } from 'react'
// import swal from 'sweetalert2'
// import { apiUrls, baseUrl } from '../lib/constants'

// export default function Theatres() {
//   const [data, setData] = useState([])
//   const [theatreDesc, settheatreDesc] = useState("Theatre")
//   const [theatrecapacity, settheatrecapacity] = useState(1)
//   const [showadd, setshowadd] = useState(true)
//   const [showseat, setshowseat] = useState(false)
//   const [theatre, settheatre] = useState()
//   const [seattypes, setseattypes] = useState([])
//   const [seattypeid, setseattypeid] = useState()
//   const [seatcount, setseatcount] = useState()

//   const handleSubmit = (e) => {
//     e.preventDefault()
//     if (theatreDesc == undefined) {
//       swal.fire({
//         title: 'Error',
//         icon: 'error',
//         text: 'Please fill all details',
//       })
//       return
//     }
//     axios
//       .post(baseUrl+apiUrls.THEATRE_URL, {
//         theatreDesc: theatreDesc,
//         theatrecapacity: theatrecapacity,
//       })
//       .then((resp) => {
//         console.log(resp)
//         swal.fire({
//           title: 'Success',
//           text: resp.data,
//         })
//         settheatreDesc('')
//         settheatrecapacity('')
//         loadData()
//       })
//       .catch((err) => {
//         swal.fire({
//           title: 'error',
//           icon: 'error',
//           text: 'Cannot save theatre',
//         })
//       })
//   }
  
//   const handleDelete = (id) => {
//     axios
//       .delete(baseUrl+apiUrls.THEATRE_URL + '/'+ id)
//       .then((resp) => {
//         swal.fire({
//           icon: 'error',
//           title: 'Deleted',
//           text: resp.data,
//         })
//         loadData()
//       })
//       .catch((err) => {
//         swal.fire({
//           title: 'Error',
//           icon: 'error',
//           text: 'Cannot delete theatre',
//         })
//       })
//   }
//   const loadData = () => {
//     axios.get(baseUrl+apiUrls.THEATRE_URL).then((resp) => {
//       setData(resp.data)
//     })
//   }
//   useEffect(() => {
//     loadData()
//   }, [])
//   return (
//     <>
//       <div className='container mt-5'>
//         <div className='row'>
//           <div className='col-sm-8'>
//             <h5 className='p-2'>theatres List</h5>
//             <table className='table table-bordered'>
//               <thead>
//                 <th>Id</th>
//                 <th>theatre Name</th>
//                 <th>theatrecapacity</th>
//                 <th>Action</th>
//               </thead>
//               <tbody>
//                 {data?.map((x) => (
//                   <tr key={x?.theatreId}>
//                     <td>{x?.theatreId}</td>
//                     <td>{x?.theatreDesc}</td>
//                     <td>{x?.theatrecapacity}</td>                    
//                     <td>
//                       <button
//                         onClick={(e) => handleDelete(x.theatreId)}
//                         className='btn btn-danger btn-sm me-2'
//                       >
//                         Delete
//                       </button>                      
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           </div>
//           <div className='col-sm-4'>
//             {showadd && (
//               <div className='card'>
//                 <div className='card-header text-center'>
//                   <h5>Add Theatre</h5>
//                 </div>
//                 <div className='card-body'>
//                   <form>
//                     <div className='mb-2'>
//                       <label>Theatre Name</label>
//                       <input
//                         type='text'
//                         className='form-control form-control-sm'
//                         value={theatreDesc}
//                         onChange={(e) => settheatreDesc(e.target.value)}
//                       />
//                     </div>
//                     <div className='mb-2'>
//                       <label>theatrecapacity</label>
//                       <input
//                         type='number'
//                         max='80'                        
//                         className='form-control form-control-sm'
//                         value={theatrecapacity}
//                         onChange={(e) => settheatrecapacity(e.target.value)}
//                       />
//                     </div>
//                     <button
//                       onClick={handleSubmit}
//                       className='btn btn-primary btn-sm float-end'
//                     >
//                       Save Details
//                     </button>
//                   </form>
//                 </div>
//               </div>
//             )}

//           </div>
//         </div>
//       </div>
//     </>
//   )
// }




import axios from 'axios'
import { useEffect, useState } from 'react'
import swal from 'sweetalert2'
import { apiUrls, baseUrl } from '../lib/constants'

export default function Theatres() {
  const [data, setData] = useState([])
  const [theatreDesc, setTheatreDesc] = useState('Theatre')
  const [theatrecapacity, settheatrecapacity] = useState(1)
  const [theatreCity, setTheatreCity] = useState('')
  const [managerNum, setManagerNum] = useState('')
  const [showAdd, setShowAdd] = useState(true)

  const handleSubmit = (e) => {
    e.preventDefault()
    if (!theatreDesc || !theatrecapacity || !theatreCity || !managerNum) {
      swal.fire({
        title: 'Error',
        icon: 'error',
        text: 'Please fill all details',
      })
      return
    }
    axios
      .post(baseUrl + apiUrls.THEATRE_URL, {
        theatreDesc: theatreDesc,
        theatrecapacity: theatrecapacity,
        theatreCity: theatreCity,
        managerNum: managerNum,
      })
      .then((resp) => {
        console.log(resp)
        swal.fire({
          title: 'Success',
          text: resp.data,
        })
        setTheatreDesc('')
        settheatrecapacity('')
        setTheatreCity('')
        setManagerNum('')
        loadData()
      })
      .catch((err) => {
        swal.fire({
          title: 'error',
          icon: 'error',
          text: 'Cannot save theatre',
        })
      })
  }

  const handleDelete = (id) => {
    axios
      .delete(baseUrl + apiUrls.THEATRE_URL + '/' + id)
      .then((resp) => {
        swal.fire({
          icon: 'error',
          title: 'Deleted',
          text: resp.data,
        })
        loadData()
      })
      .catch((err) => {
        swal.fire({
          title: 'Error',
          icon: 'error',
          text: 'Cannot delete theatre',
        })
      })
  }

  const loadData = () => {
    axios.get(baseUrl + apiUrls.THEATRE_URL).then((resp) => {
      setData(resp.data)
    })
  }

  useEffect(() => {
    loadData()
  }, [])

  return (
    <>
      <div className='container mt-5'>
        <div className='row'>
          <div className='col-sm-8'>
            <h5 className='p-2'>Theatres List</h5>
            <table className='table table-bordered'>
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Theatre Name</th>
                  <th>Theatre Capacity</th>
                  <th>Theatre City</th>
                  <th>Manager Contact</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                {data.map((x) => (
                  <tr key={x.theatreId}>
                    <td>{x.theatreId}</td>
                    <td>{x.theatreDesc}</td>
                    <td>{x.theatrecapacity}</td>
                    <td>{x.theatreCity}</td>
                    <td>{x.managerNum}</td>
                    <td>
                      <button
                        onClick={() => handleDelete(x.theatreId)}
                        className='btn btn-danger btn-sm me-2'
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
          <div className='col-sm-4'>
            {showAdd && (
              <div className='card'>
                <div className='card-header text-center'>
                  <h5>Add Theatre</h5>
                </div>
                <div className='card-body'>
                  <form>
                    <div className='mb-2'>
                      <label>Theatre Name</label>
                      <input
                        type='text'
                        className='form-control form-control-sm'
                        value={theatreDesc}
                        onChange={(e) => setTheatreDesc(e.target.value)}
                      />
                    </div>
                    <div className='mb-2'>
                      <label>Theatre Capacity</label>
                      <input
                        type='number'
                        max='80'
                        className='form-control form-control-sm'
                        value={theatrecapacity}
                        onChange={(e) => settheatrecapacity(e.target.value)}
                      />
                    </div>
                    <div className='mb-2'>
                      <label>Theatre City</label>
                      <input
                        type='text'
                        className='form-control form-control-sm'
                        value={theatreCity}
                        onChange={(e) => setTheatreCity(e.target.value)}
                      />
                    </div>
                    <div className='mb-2'>
                      <label>Manager Contact</label>
                      <input
                        type='text'
                        className='form-control form-control-sm'
                        value={managerNum}
                        onChange={(e) => setManagerNum(e.target.value)}
                      />
                    </div>
                    <button
                      onClick={handleSubmit}
                      className='btn btn-primary btn-sm float-end'
                    >
                      Save Details
                    </button>
                  </form>
                </div>
              </div>
            )}
          </div>
        </div>
      </div>
    </>
  )
}
