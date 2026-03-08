package com.lab.fitnesstracker;

    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import com.google.gson.Gson;

    import java.io.IOException;
    @WebServlet("/tracker")
    public class TrackerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Tracker tracker = new Tracker("WHOOP 5.0","whoop.jpg","Фітнес-браслет WHOOP 5.0 with Obsidian SuperKnit Band Peak Membership Чорний",12900,"пластик");

        Gson gson = new Gson();
        String json = gson.toJson(tracker);

        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }
}

