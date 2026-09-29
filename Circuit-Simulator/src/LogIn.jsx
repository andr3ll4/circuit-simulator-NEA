import {Link} from "react-router-dom";

function LogIn() {
    return (
        <div className="login">
            <h1>Log In</h1>
            <form>
                <input required type="text" placeholder="Username" />
                <input required type="password" placeholder="Password" />
                <button type="submit">Submit</button>
            </form>
            <p style={{ color: 'rgb(198, 193, 193)' , fontSize: '14px' }}>New here? <Link to="/"><a className = "link">Sign Up</a></Link></p>
        </div>
    );
}


export default LogIn;   
                    