import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {faAt, faLock} from "@fortawesome/free-solid-svg-icons";

type LoginInputProps = {
  id: string;
  type: "text" | "password";
  placeholder: string;
};

const LoginInput = (props: LoginInputProps) => {
  return (
    <div className="login__input_wrapper">
      <FontAwesomeIcon
        className="login__input_icon"
        icon={props.id === "email" ? faAt : faLock}
      />
      <input
        className="login__input"
        id={props.id}
        type={props.type}
        placeholder={props.placeholder}
      />
    </div>
  );
};

export default LoginInput;
