import React, { use } from 'react'
import MyTextInput from '../commons/MyTextInput'
import { useNavigate } from 'react-router-dom';

export default function LoginPage() {

    const navigateTo = useNavigate();

    const handbleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        navigateTo('/dashboard');
    }

  return (
    <div className='row'>
        <div className='col justify-content-end align-items-center d-flex'>
            <img src='../public/appIcon.png' alt="Logo" className="img-fluid" style={{width:"40%", height:"auto"}} />
        </div>
        <div className='col justify-content-start align-items-center d-flex'>
            <form onSubmit={handbleSubmit}>
                <MyTextInput label="Email" name="Email" type="email" value="" onChange={()=>{}} />
                <MyTextInput label="Password" name="password" type="password" value="" onChange={()=>{}} />
                <button className='btn btn-primary' type='submit'>Login</button>
            </form>
        </div>
    </div>
  )
}
