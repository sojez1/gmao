import { createRoot } from 'react-dom/client'
import './index.css'
import { RouterProvider } from 'react-router-dom'
import { MesRoutes } from './routes/MesRoutes.tsx'

createRoot(document.getElementById('root')!).render(
 <RouterProvider router={MesRoutes}/> 

)
