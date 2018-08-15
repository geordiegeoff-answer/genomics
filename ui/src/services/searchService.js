import axios from 'axios'

export async function getAll() {
    let response;
    await axios.get('http://localhost:8080/geolocation/all').then(res => {
        response = res.data;
    }).catch(err => {
        console.error(err);
    });
    return response;
}

export async function getLabLocations() {
    let response;
    await axios.get('http://localhost:8080/geolocation/labs').then(res => {
        response = res.data;
    }).catch(err => {
        console.error(err);
    });
    return response;
}

export async function filter(body) {
    let response;
    await axios({
        method:'POST',
        headers: {
            'content-type': 'application/json'
        },
        data: body,
        url: 'http://localhost:8080/geolocation/search'
    }).then(res => {
        response = res.data;
    }).catch(err => {
        console.error(err);
    });
    return response;
}
