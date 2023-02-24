import "./Login.css"; 

import LoginInput from "./Login.Input";

const Login = () => {
  return (
    <div className="login__container">
      <form className="login__form">
        <h1 className="login__heading">Sign up</h1>

        <LoginInput 
          id="email"
          type="text"
          placeholder="Enter your email" 
        />

        <LoginInput
          id="password"
          type="password"
          placeholder="Enter your password"
        />

        <button className="login__button"> Login </button>
        <p className="login__forgot_password">Forgot password?</p>
      </form>
    </div>
  );
};

export default Login;
