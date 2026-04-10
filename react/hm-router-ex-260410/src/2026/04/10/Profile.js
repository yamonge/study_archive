import React from "react";
import { useLocation } from "react-router-dom";

const Profile = () => {
  const location = useLocation();
  const data = location.state;

  return (
    <>
      <p>{data.job}</p>
    </>
  );
};

export default Profile;
