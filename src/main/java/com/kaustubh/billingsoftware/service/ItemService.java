package com.kaustubh.billingsoftware.service;

import com.kaustubh.billingsoftware.io.ItemRequest;
import com.kaustubh.billingsoftware.io.ItemResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    ItemResponse add(ItemRequest request , MultipartFile file);

    List<ItemResponse> fetchItems();

    void deleteItem(String itemId);
}
