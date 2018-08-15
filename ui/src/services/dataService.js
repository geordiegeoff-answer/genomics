import axios from 'axios'

export async function getData() {
    let response;
    await axios.get('http://localhost:8080/data/all').then(res => {
        response = res.data;
    }).catch(err => {
        console.error(err);
    });
    return response;
}

export async function getTrusts(trustName) {
    let response;
    await axios.get('http://localhost:8080/data/trust/' + trustName).then(res => {
        response = res.data;
    }).catch(err => {
        console.error(err);
    });
    return response;
}