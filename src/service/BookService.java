package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import api.dao.IBookDAO;
import api.dao.IRequestDAO;
import api.dao.IStockDAO;
import api.model.IBook;
import api.model.IBookInStock;
import api.model.IBookRequest;
import api.service.IBookService;
import dao.DAOFactory;
import model.BookInStock;
import utility.Constants.BookSort;
import utility.Constants.RequestSort;
import utility.Constants.StaleBookSort;
import utility.Constants;
import utility.Converter;

public class BookService implements IBookService {
    private IBookDAO bookDAO;
    private IStockDAO stockDAO;
    private IRequestDAO requestDAO;

    public BookService() throws Exception {
        bookDAO = DAOFactory.getBookDAO();
        stockDAO = DAOFactory.getStockDAO();
        requestDAO = DAOFactory.getRequestDAO();
    }

    @Override
    public Map<IBook, Integer> getAllBooks(BookSort sort) throws Exception {
        List<IBook> allBooks = bookDAO.getAllBooks();
        List<IBookInStock> booksInStock = stockDAO.getStock();
        return getBookStockMap(allBooks, booksInStock);
    }

    @Override
    public Map<IBook, Integer> getRequests(RequestSort sort) throws Exception {
        List<IBook> allBooks = bookDAO.getAllBooks();
        List<IBookRequest> requests = requestDAO.getAllRequests();
        return getBookRequestMap(allBooks, requests);
    }
    
    @Override
    public Map<IBook, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception {
        List<IBook> allBooks = bookDAO.getAllBooks();
        List<IBookInStock> booksInStock = stockDAO.getStock();
        return getStaleBooksMap(allBooks, booksInStock);
    }
    
    @Override
    public String getBookDescription(int bookId) throws Exception {
        return bookDAO.getBookDescriprion(bookId);
    }

    @Override
    public boolean addBookToStock(IBook book) throws Exception {
        List<IBookInStock> booksInStock = stockDAO.getStock();
        int previousId = booksInStock.get(booksInStock.size() - 1).getId();
        if(Constants.autoRequest) {
            deleteRequests(book);
        }
        return stockDAO.addRecord(new BookInStock(previousId + 1, book.getId(), new Date()));
    }

    private void deleteRequests(IBook book) throws Exception {
        List<IBookRequest> requests = requestDAO.getAllRequests();
        
        for(IBookRequest request : requests) {
            if(request.getBookId() == book.getId()) {
                requestDAO.deleteRecord(request.getRequestId());
            }
        }
    }

    private Map<IBook, Integer> getBookStockMap(List<IBook> books, List<IBookInStock> booksInStock) {
        Map<IBook, Integer> map = new HashMap<>();
        
        for(IBook book : books) {
            int quantity = 0;
            
            for(IBookInStock bookInStock : booksInStock) {
                if(book.getId() == bookInStock.getBookId()) {
                    quantity++;
                }
            }
            map.put(book, quantity);
        }
        return map;
    }
    
    private Map<IBook, Integer> getBookRequestMap(List<IBook> books, List<IBookRequest> requests) {
        Map<IBook, Integer> map = new HashMap<>();
        
        for(IBook book : books) {
            int quantity = 0;
            
            for(IBookRequest request : requests) {
                if(book.getId() == request.getBookId()) {
                    quantity++;
                }
            }
            if(quantity > 0) {
                map.put(book, quantity); 
            }
        }
        return map;
    }

    private Map<IBook, List<Date>> getStaleBooksMap(List<IBook> books, List<IBookInStock> booksInStock) {
        booksInStock = Converter.getStaleBooks(booksInStock);
        Map<IBook, List<Date>> map = new HashMap<>();
        
        for(IBook book : books) {
            for(IBookInStock bookInStock : booksInStock) {
                if(book.getId() == bookInStock.getBookId()) {
                    if(map.get(book) == null) {
                        map.put(book, new ArrayList<>());
                    }
                    map.get(book).add(bookInStock.getDate());
                }
            }
        }
        return map;
    }
    
    
}
