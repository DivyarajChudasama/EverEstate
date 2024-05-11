import {auth} from 'express-oauth2-jwt-bearer'

const jwtCheck = auth({
    audience: "http://localhost:3000",
    issuerBaseURL: "https://dev-uu04hclsu33wv0bk.us.auth0.com",
    tokenSigningAlg: "RS256"
})

export default jwtCheck