package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import api.annotations.Inject;
import api.dao.IBookDAO;
import api.model.IBook;
import api.model.IBookInStock;
import api.model.IBookRequest;
import api.service.IBookService;
import api.service.IRequestService;
import api.service.IStockService;
import facade.LibraryFacade;
import utility.Constants.BookSort;
import utility.Constants.RequestSort;
import utility.Constants.StaleBookSort;
import utility.Constants.TypeDAO;
import utility.ConfigHandler;
import utility.Converter;

public class BookService implements IBookService {
    @Inject(daoType = TypeDAO.BOOK_DAO) 
    private IBookDAO bookDAO;
    private ConfigHandler.Configs configs;

    public BookService(ConfigHandler.Configs configs) throws Exception {
        this.configs = configs;
    }

    @Override
    public Map<IBook, Integer> getAllBooks(BookSort sort) throws Exception {
        List<IBook> allBooks = bookDAO.getAllBooks();
        IStockService stockService = LibraryFacade.getInstance().stockService;
        List<IBookInStock> booksInStock = stockService.getStock();
        return getBookStockMap(allBooks, booksInStock);
    }

    @Override
    public Map<IBook, Integer> getRequests(RequestSort sort) throws Exception {
        List<IBook> allBooks = bookDAO.getAllBooks();
        IRequestService requestService = LibraryFacade.getInstance().requestService;
        List<IBookRequest> requests = requestService.getAllRequests();
        return getBookRequestMap(allBooks, requests);
    }
    
    @Override
    public Map<IBook, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception {
        List<IBook> allBooks = bookDAO.getAllBooks();
        IStockService stockService = LibraryFacade.getInstance().stockService;
        List<IBookInStock> booksInStock = stockService.getStock();
        return getStaleBooksMap(allBooks, booksInStock);
    }
    
    @Override
    public String getBookDescription(int bookId) throws Exception {
        return bookDAO.getBookDescriprion(bookId);
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
        booksInStock = Converter.getStaleBooks(booksInStock, configs.unsoldMonth);
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
