$(document).ready(function () {
  var urlRecent = "https://fcctop100.herokuapp.com/api/fccusers/top/recent";
  var urlAllTime = "https://fcctop100.herokuapp.com/api/fccusers/top/alltime";

  var App = React.createClass({
    getInitialState() {
      return {
        users: [],
        active: "recent",
      };
    },
    getAndUpdateUsers: function (url, active) {
      $.getJSON(
        url,
        function (data) {
          this.setState({
            users: data,
            active: "" + active,
          });
        }.bind(this)
      );
    },
    recentClick: function (e) {
      this.getAndUpdateUsers(urlRecent, "recent");
    },
    alltimeClick: function (e) {
      this.getAndUpdateUsers(urlAllTime, "allTime");
    },
    componentDidMount: function () {
      this.getAndUpdateUsers(urlRecent, "recent");
    },
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

  ReactDOM.render(<App />, document.getElementById("app"));
});
