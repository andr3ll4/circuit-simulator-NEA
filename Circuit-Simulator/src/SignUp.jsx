 import {Link} from "react-router-dom";


function SignUp() {
    return (
        <div className="SignUp">
            <h1>Sign Up</h1>
            <form>
                <select className = "select" required>
                    <option disabled >Account type</option>
                    <option value="Personal">Personal</option>
                    <option value="Student">Student</option>
                    <option value="Teacher">Teacher</option>
                </select>
                    <input required type="text" placeholder="Username" />
                    <input required type="email" placeholder="Email" />
                    <input required type="password" placeholder="Password" />
                    <input required type="password" placeholder="Re-enter Password" />
                    <button type="submit">Submit</button>
            </form>
            <p style={{ color: 'rgb(198, 193, 193)' , fontSize: '14px' }}>Already have an account?<Link to="/LogInPage"><a className = "link">Log In</a></Link></p>
            
        </div>
    );
}


export default SignUp;