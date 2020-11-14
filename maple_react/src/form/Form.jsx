import React from 'react'

const Form = ({ handleSubmit, config, handleChange }) => {
    const { userName, userEmail } = config
    return (
        <>
          <div className="custom-zn__container">
        <div className="custom-zm__modal">
          <div className="custom-zm__title__box">
            <h1 className="custom-zm__title">Welcome to Zoom</h1>
          </div>
          <form onSubmit={handleSubmit}>
            <label className="custom-zm__modal__label" htmlFor="userName">
              User Name (required*)
              <input
                type="text"
                value={userName}
                className="custom-zm__modal__input"
                onChange={handleChange}
                id="userName"
                placeholder="User Name"
              />
            </label>
            <label className="custom-zm__modal__label" htmlFor="userEmail">
              Email (optional)
              <input
                type="email"
                value={userEmail}
                className="custom-zm__modal__input"
                onChange={handleChange}
                id="userEmail"
                placeholder="Email"
              />
            </label>
            <div className="custom-zm__btn__box">
              <button className="custom-zm__btn" type="submit">
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>   
        </>
    )
}


export default Form
