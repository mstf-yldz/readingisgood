package com.getir.readingisgood.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getir.readingisgood.data.BookRepository;
import com.getir.readingisgood.data.OrderRepository;
import com.getir.readingisgood.modal.Book;
import com.getir.readingisgood.modal.Order;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	public Order placeOrder(Order order) {
		setBooksIsInOrderProcess(order);
		order.setTotalAmount(calculateTotalAmount(order));
		updateOrderCreateDate(order);
		reduceBooksStockCount(order);
		setBooksIsNotInOrderProcess(order);
		order.setId(sequenceGeneratorService.generateSequence(Order.SEQUENCE_NAME));
		return orderRepository.save(order);
	}
	
	@Override
	public Order findById(long id) {
		Optional<Order> orderOpt = orderRepository.findById(id);
		return orderOpt.isPresent() ? orderOpt.get() : null;
	}
	
	public void reduceBooksStockCount(Order order) {
		order.getOrderBooks().forEach(orderBook -> {
			Optional<Book> bookOpt = bookRepository.findById(orderBook.getBook().getId());
			if(bookOpt.isPresent()) {
				Book book = bookOpt.get();
				book.setStockCount(book.getStockCount() - orderBook.getCount());
				bookRepository.save(book);
			}
		});
	}

	public void setBooksIsInOrderProcess(Order order) {
		order.getOrderBooks().stream().forEach(orderBook -> {
			Optional<Book> dbBookOptional = bookRepository.findById(orderBook.getBook().getId());
			if(dbBookOptional.isPresent()) {
				Book dbBook = dbBookOptional.get();
				dbBook.setInOrderProcess(true);
				bookRepository.save(dbBook);
			}else {
				//throw book is in out of stock
			}
		});
	}
	
	public void setBooksIsNotInOrderProcess(Order order) {
		order.getOrderBooks().stream().forEach(orderBook -> {
			Optional<Book> dbBookOptional = bookRepository.findById(orderBook.getBook().getId());
			if(dbBookOptional.isPresent()) {
				Book dbBook = dbBookOptional.get();
				dbBook.setInOrderProcess(false);
				bookRepository.save(dbBook);
			}else {
				//it has to be. Something went wrong!
			}
		});
	}
	
	@Override
	public List<Order> findByOrderDateBetween(LocalDateTime from, LocalDateTime to) {
		return orderRepository.findByOrderDateBetween(from, to);
	}
	
	private void updateOrderCreateDate(Order order) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		order.setOrderDate(LocalDateTime.parse(LocalDateTime.now().format(formatter), formatter));
	}
	
	private double calculateTotalAmount(Order order) {
		return order.getOrderBooks().stream().mapToDouble(item -> item.getBook().getPrice()).sum();
	}
}
