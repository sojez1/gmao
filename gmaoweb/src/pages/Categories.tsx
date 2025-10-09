import React, { useEffect, useState } from 'react'
import { gmaoApi } from '../axios/axiosDefaultConfig';
import type { categorieType } from '../commons/datatypes';
import MyTextInput from '../commons/MyTextInput';

export default function Categories() {

    const [categorie, setCategorie] = useState<categorieType>({});
    const [listeCategories, setListeCategories] = useState<categorieType[]>([]);
    const [filtreCategorie, setFiltreCategorie] = useState<string>("");
    const [btnSuccess, setBtnSuccess] = useState<boolean>(false);
    const [btnError, setBtnError] = useState<any | null>(null);
    const [btnLoading, setBtnLoading] = useState<boolean>(false);

  

    const deleteCategorie = async (id?: number) => {
        if(!id) return;
        try{
            await gmaoApi.delete(`/materiels/categories/${id}`);
            // Rafraichir la liste des categories
            getAllCategories();
        }catch(err: any){
            if (err instanceof Error)
            console.error("Error deleting categorie:", err.message);
        }
    }


    const handleSaveCategorie = async (event: React.FormEvent) => {
        event.preventDefault();
        setBtnLoading(true);
        setBtnError(null);
        setBtnSuccess(false);

        try{
            await gmaoApi.post('/materiels/categories', categorie);
            setBtnLoading(false);
            setBtnSuccess(true);
            setCategorie({}); // reinitialiser le formulaire
            // Rafraichir la liste des categories
            getAllCategories();

        }catch(err: any){
            setBtnError(true)
            if (err instanceof Error)
            console.error("Error saving categorie:", err.message);

        }
        finally{
            setBtnLoading(false);
        }

        
    }   // fin handleSaveCategorie


    const getAllCategories = async () => {
        const response = (await gmaoApi.get('/materiels/categories'));
        setListeCategories(response.data);
    }

    const listeCategoriesFiltree = listeCategories.filter(cat =>
        cat.code.toLowerCase().includes(filtreCategorie.toLowerCase()) ||
        cat.designation.toLowerCase().includes(filtreCategorie.toLowerCase())
    );

    useEffect(() =>{
        getAllCategories();
    },[])


 

    const handleCategorieChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setCategorie(prevCategValue => ({
            ...prevCategValue,
            [name]: value
        }));
    }   

  return (
    <div className='container my-4'>
        <div>
            {btnLoading && <div className="alert alert-info">Enregistrement en cours...</div>}
            {btnSuccess && <div className="alert alert-success">Categorie enregistrée avec succès!</div>}
            {btnError && <div className="alert alert-danger">Erreur lors de l'enregistrement de la categorie.</div>}
            <form onSubmit={handleSaveCategorie}>
                <h3>Enregistrer une nouvelle Categories</h3>
                <MyTextInput label="Code" name="code" value={categorie.code || ''} onChange={handleCategorieChange} />
                <MyTextInput label="Designation" name="designation" value={categorie.designation || ''} onChange={handleCategorieChange} />
                <button className="btn btn-primary" type="submit">{btnLoading?"Loading":"Enregistrer"}</button>  
            </form>
        </div>
        

        <div>
            <h3>Liste des Categories</h3>
            <div className='form-row'>
                <label>Filtrer</label>
                <input className='form-control mb-2' type="text" value={filtreCategorie} onChange={(e)=>setFiltreCategorie(e.target.value)} placeholder='Taper pour filtrer...' />
            </div>
            <table className='table table-striped mt-4 shadow'>
            <thead className='table-header'>
                <tr>
                    <th>id</th>
                    <th>code</th>
                    <th>Appelation</th>
                    <th colSpan={3}>Actions</th>
                </tr>
            </thead>
            <tbody>
                {listeCategoriesFiltree.map(cat =>(
                    <tr key={cat.id}>
                        <td>{cat.id}</td>
                        <td>{cat.code}</td>
                        <td>{cat.designation}</td>
                        <button className='btn btn-primary mx-2'>View</button>
                        <button className='btn btn-warning mx-2'>Edit</button>
                        <button className='btn btn-danger' onClick={()=>deleteCategorie(cat.id)}>Delete</button>
                    </tr>
                    ))
                } 
                    
            </tbody>
        </table>
        </div>
    </div>
  )
}
