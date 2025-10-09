export type categorieType = {
    id?: number;
    code: string;
    designation: string;
}

export type textInputType = {
    type?: string;
    label: string;
    name: string;
    value: string;
    onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
}
    
