$(document).ready(function () {
    // URLs de la API para obtener los datos de los usuarios
    var urlRecent = "https://fcctop100.herokuapp.com/api/fccusers/top/recent";
    var urlAllTime = "https://fcctop100.herokuapp.com/api/fccusers/top/alltime";
  
    // Definición del componente principal de React
    var App = React.createClass({
      // Estado inicial del componente
      getInitialState() {
        return {
          users: [], // arreglo vacío para los usuarios
          active: "recent", // estado activo inicial para los puntos recientes
        };
      },
      // Función para obtener y actualizar la lista de usuarios en el estado
      getAndUpdateUsers: function (url, active) {
        $.getJSON(
          url,
          function (data) {
            this.setState({
              users: data, // datos obtenidos de la API
              active: "" + active, // estado activo actualizado
            });
          }.bind(this)
        );
      },
      // Función para manejar el click en los puntos recientes
      recentClick: function (e) {
        this.getAndUpdateUsers(urlRecent, "recent");
      },
      // Función para manejar el click en los puntos totales
      alltimeClick: function (e) {
        this.getAndUpdateUsers(urlAllTime, "allTime");
      },
      // Función que se ejecuta después de que el componente es montado
      componentDidMount: function () {
        this.getAndUpdateUsers(urlRecent, "recent"); // obtener datos de la API y actualizar estado
      },
      // Función para renderizar el componente
      render: function () {
        return (
          <div>
            <h1>Camper Leaderboard</h1>
            <table className="table">
              <tr>
                <th>#</th>
                <th>Camper Name</th>
                <th onClick={this.recentClick}>
                  Points in past 30 days{" "}
                  <span className={this.state.active == "recent" ? "" : "none"}>
                    &#9660;
                  </span>
                </th>
                <th onClick={this.alltimeClick}>
                  All time points{" "}
                  <span className={this.state.active == "recent" ? "none" : ""}>
                    &#9660;
                  </span>
                </th>
              </tr>
              {this.state.users.map(function (item, index) {
                return (
                  <tr>
                    <td>{index + 1}</td>
                    <td>
                      <a
                        href={"https://www.freecodecamp.com/" + item.username}
                        target="_blank"
                      >
                        {" "}
                        <img className="user-img" src={item.img} />
                        {item.username}
                      </a>
                    </td>
                    <td>{item.recent}</td>
                    <td>{item.alltime} </td>
                  </tr>
                );
              })}
            </table>
          </div>
        );
      },
    });
  
    // Renderizar el componente en el elemento con el ID "app"
    ReactDOM.render(<App />, document.getElementById("app"));
  });
  
