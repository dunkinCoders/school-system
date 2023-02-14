import "./Login.css"; 


const Login = () => {
  return (
    <div className="login__container">
      <form className="login__form">
        <h1 className="login__heading">Sign up</h1>

        {/*make it a separate component later*/}
        <div className="login__input_wrapper">
          <label htmlFor="login">Login</label>
          <input className="login__input" id="login" type="text" />
        </div>

        {/*make it a separate component later */}
        <div className="login__input_wrapper">
          <label htmlFor="password">Password</label>
          <input className="login__input" id="password" type="password" />
        </div>

        <button className="login__button"> Login </button>

        <p className="login__forgot_password">Forgot password?</p>
      </form>
    </div>
  );
};

export default Login;
