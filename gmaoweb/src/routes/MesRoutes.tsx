import React from 'react'
import {createBrowserRouter } from "react-router-dom"
import Categories from '../pages/Categories'
import Dashboard from '../pages/Dashboard'
import LoginPage from '../pages/LoginPage'
import AjoutMateriel from '../pages/AjoutMateriel'
import App from '../App'
import ListeMateriels from '../pages/ListeMateriels'



export const MesRoutes = createBrowserRouter([
    { // debut des routes devant apparaitre dans le navbar
        path:"/", 
        element: <App/>,
        children:[
            {index:true, element:<Dashboard/>}, // default route (page par defaut)
            {path:"categories", element:<Categories/>},
            {path:"newmateriel", element:<AjoutMateriel/>},
            {path:"listemateriel", element:<ListeMateriels/>},
            {path:"dashboard", element:<Dashboard/>}
            
        ],
    },

    // pages ne devant pas apparaitre avec le navbar
    {path:"login", element:<LoginPage/>},
    ],  // fin des routes

    {basename: "/gmao"}
)
