import { Link } from "react-router-dom";

const Sidebar = () => {
  return (
    <div className="sidebar">
      <Link to="/schedule"> Schedule </Link>
      <Link to="/journals"> Journals </Link>
    </div>
  );
};

export default Sidebar;
