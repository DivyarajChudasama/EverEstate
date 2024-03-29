import {BrowserRouter, Routes,Route} from 'react-router-dom';
import Home from './pages/Home';
import About from './pages/About';
import Signin from './pages/Signin';
import Signout from './pages/Signout';
import Profile from './pages/Profile';
import Header from './components/Header';
import SignUp from './pages/SignUp';
import PrivateRoute from './components/PrivateRoute'
export default function App() {
  return <BrowserRouter>
  <Header/>
  <Routes>
    <Route path='/' element={<Home/>}/>
    <Route path='/about' element={<About/>}/>
    <Route path='/signin' element={<Signin/>}/>
    <Route path='/signout' element={<Signout/>}/>
    <Route path='/signup' element={<SignUp/>}/>
    <Route path='/profile' element={<Profile/>}/>
    <Route element={<PrivateRoute/>}/>
  </Routes>
  </BrowserRouter>
}
