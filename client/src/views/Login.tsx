const Login = () => {
  return (
    <div className="login-wrapper">
      <form className="login-form">
        <h1 className="mb-2">Sign up</h1>

        {/*make it a separate component later*/}
        <div className="login-input-wrapper">
          <label htmlFor="login">Login</label>
          <input className="login-input" id="login" type="text" />
        </div>

        {/*make it a separate component later */}
        <div className="login-input-wrapper">
          <label htmlFor="password">Password</label>
          <input className="login-input" id="password" type="password" />
        </div>

        <button className="login-button"> Login </button>

        <p className="text soft">Forgot password?</p>
      </form>
    </div>
  );
};

export default Login;
