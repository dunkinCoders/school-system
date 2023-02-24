import { Link } from "react-router-dom";
import "./Header.css";

const Header = () => {
  return (
    <div className="header">
      <div className="header__section">
        <h1 className="header__title">
          <Link
            className="header__title_link"
            to="/"
          >
            Journal
          </Link>
        </h1>

        <Link
          className="header__link"
          to="/schedule"
        >
          Schedule
        </Link>
        <Link
          className="header__link"
          to="/journals"
        >
          Journals
        </Link>
      </div>
      <div className="header__section">
        <Link
          className="header__link"
          to="/profile"
        >
          Profile
        </Link>
        <Link
          className="header__link"
          to="/login"
        >
          Login
        </Link>
      </div>
    </div>
  );
};

export default Header;
