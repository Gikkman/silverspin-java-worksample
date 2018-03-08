package com.silver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SilverServlet
 */
@WebServlet(urlPatterns = { "/list", "/add", "/prices" })
public class SilverServlet extends HttpServlet
{
	private static final long serialVersionUID = 711040514396027371L;
	private final Map<String, Integer> prices = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SilverServlet()
	{
		super();
		prices.put("apple", 1);
		prices.put("banana", 1);
		prices.put("flour", 2);
		prices.put("milk", 5);
		prices.put("egg", 1);
		prices.put("butter", 11);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		switch (request.getServletPath())
		{
			case "/list":
				System.out.println("The user requested /list");
				break;
			case "/add":
				System.out.println("The user requested /add");
				break;
			case "/prices":
				System.out.println("The user requested /prices");
				break;
		}
		response.getWriter().append("Get from: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Redirect to GET
		doGet(request, response);
	}
}
