import React from 'react'
import { Link } from 'react-router-dom'

export default function NavBar() {
  return (
    <nav className="navbar fixed-top" style={styles.navBar}>
        <a className='navbar-brand'>
          <img src="/appIcon.png" alt="Logo" className="logo" style={{height:"120px", width:"auto"}}/>
          <span>Asset Management System</span>
        </a>

        <ul className='nav-item dropdown' data-toggle="dropdown" aria-expanded="false">Materiel
            <li className='dropdown-item'><Link to="categories" >Categories</Link></li>            
            <li className='dropdown-item'><Link to="newmateriel">Inserer nouveau materiels</Link></li>            
            <li className='dropdown-item'><Link to="listemateriel">Liste materiels</Link></li>
        </ul>
        
        <ul>Interventions
            <li>demander une intervention</li>
            <li>Liste des interventions</li>
            <li>Rapporter une intyervention</li>
          </ul>
        <ul>Profil
            <li><Link to="login">login</Link></li>
            <li>logout</li>
            <li>Modifier mot de passe</li>
        </ul>             
        <ul>Administration
            <li>Creer un nouvel utilisateur</li>
            <li>Liste des utilisateurs</li>
            <li>Parametres de l'application</li>
        </ul>
    </nav>
  )
}


const styles = {
    navBar:{
        backgroundColor:"#eee5f4ff",
        padding:"1px",
        display:"flex",
        justifyContent:"space-around",
        
    }
}
