import React, { useEffect, useMemo } from 'react'
import { useState } from 'react';
import AxiosClient from '../../config/http-gateway/http-client';

const ClientePage = () => {
    const [loadin, setLoading] = useState(false);
    const [cliente, setCliente] = useState([]);
    const [filterText, setFilterText] = useState("");

    const getCliente = async () => {
        try {
            setLoading(true);
            const response = await AxiosClient({
                url: "/cliente/",
                method: "GET",
            });
            console.log(response);
            if (!response.error) {
                setCliente(response.data);
            }
        } catch (error) {
            console.log(error);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        getCliente();
    }, []);
    const filter = ()=>{
        return cliente.filter((cliente)=>cliente.clientname.includes(filterText));
    }

    return (
        <View>
      <Text>Prueba</Text>
    </View>
    )
}

export default ClientePage