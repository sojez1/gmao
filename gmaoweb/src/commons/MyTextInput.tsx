import React from 'react'

import type { textInputType } from './datatypes';

export default function MyTextInput({label, type="text", name, value, onChange}: textInputType) {

  return (
    <div className='form-group'>
        <label className="text-start" htmlFor={name}>{label}</label>
        <input className='form-control'
            type={type}
            id={name} 
            name={name} 
            value={value} 
            onChange={onChange} />
    </div>
        
  )
}
