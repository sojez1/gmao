import {Outlet} from 'react-router-dom'
import NavBar from './routes/NavBar'

function App() {
  return(
    <div className='col-12 container-fluid'> 
        <div className='row'>
            <NavBar/>
        </div>     
        <div className='row'>           
            <Outlet/>
        </div>
    </div>
  )
  
}

export default App
