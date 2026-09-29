function MainHeader() {
  return (
    <header>
      <nav className = "MainNavBar">
        <ul>  
          <h1 className = "logo" >Short Circuit</h1>
          <li><a href = "Login.jsx">Log in</a></li>
          <li><a href = "SignUp.jsx">Sign Up</a></li>
          <li><a href = "Browse.jsx">Browse</a></li>

        </ul> 
      </nav>
    </header>
  );
}

export default MainHeader;