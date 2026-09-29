import Home from './Home';
import {HashRouter as Router, Routes , Route } from "react-router-dom";
import LogInPage from './LogInPage';

function App() {
  return (
    <div className="App">
      <Home/>
      <Router>
        <Routes>
          <Route path="/" element = {<Home/>}></Route>
          <Route path = "/LogInPage" element = {<LogInPage/>}></Route>
        </Routes>
      </Router>
       
    </div>
      
  );
}

export default App;
